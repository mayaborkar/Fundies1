import ddf.minim.Minim
import kotlin.random.Random

// The per-tick probability that a mob makes noise.
const val NOISINESS = .25

/**
 * A Minecraft mob.
 */
open class Mob(
    type: String,
    maxHearts: Int,
    val behavior: Behavior,
    attackStrength: Int,
    imageFileName: String,
    soundFileName: String? = null,
    val subtitle: String? = null,
) : LivingEntity(type, imageFileName, maxHearts, attackStrength) {
    var sound = if (soundFileName == null) null else minim?.loadFile("data/sounds/$soundFileName")

    enum class Behavior { Passive, Hostile, Neutral, Boss }

    val isAggressive
        get() =
            if (!isAlive) {
                false
            } else {
                when (behavior) {
                    Behavior.Passive -> false
                    Behavior.Boss, Behavior.Hostile -> true
                    Behavior.Neutral -> status == Status.Injured
                }
            }

    /**
     * Attacks [victim], doing [attackStrength] hearts of damage. This throws
     * [IllegalArgumentException] unless [isAggressive].
     */
    override fun attack(victim: LivingEntity) {
        require(this.isAggressive)
        super.attack(victim)
    }

    /**
     * makes a sound if the subtitle is present, adds the subtitle to the game
     */
    fun makeNoise() {
        if (subtitle != null) {
            Game.addText(subtitle)
        }
        if (sound != null) {
            sound?.play()
            sound?.rewind()
        }
    }

    /**
     * randomly decides if the object should make a noise
     * if the mob is agressive then it attacks the player if it is within fighting range
     * if it is not within fighting range, it simply travels toward the player
     * if the mob is not agressive, it simply moves randomly
     */
    override fun tick() {
        // If a randomly selected double in the range 0 to 1 is less than
        // NOISINESS, call makeNoise().

        if (Random.nextDouble(0.0, 1.0) < NOISINESS) {
            makeNoise()
        }

        // If this mob is not aggressive, move in a random direction.

        if (!isAggressive) {
            moveRandomly()
        } else {
            val player = Game.player
            // If this mob is aggressive, then either attack the player (if the
            // distance to the player is less than or equal to FIGHTING_RANGE) or
            // move towards the player.

            if (Game.calculateDistance(this, player) <= FIGHTING_RANGE) {
                attack(Player())
            } else {
                moveTowards(Player())
            }
        }
    }

    companion object {
        var minim: Minim? = null
    }
}
