// 1. Make sure the code runs. (Test code after each step.)
// 2. Create an interface Attackable with one method: takeHit(Int).
// 3. Make LivingEntity implement Attackable.
// 4. Change the signature of LivingEntity.attack() so its argument is Attackable.
// 5. Create a class PunchingBag that extends Entity and implements Attackable.
//    PunchingBags are indestructible, so hitting one just causes this to be
//    printed: "Despite being hit, Punching Bag is as strong as ever."
//    Each tick, print "Punching Bag sways."
// 6. Add a PunchingBag to the list entities.
// 7. Modify Player so it also attacks Attackable items that are not LivingEntitys.
// 8. Make sure Steve attacks the PunchingBag while still destroying the Zombie
//    and not attacking the Chicken or himself.

// To simplify implementation, we will never remove elements from entities.
val entities: List<Entity> = listOf(Zombie(), Chicken(), Sand(), Player(), PunchingBag())

abstract class Entity(val type: String) {
    abstract fun tick()
    override fun toString() = type
}

/**
 * Represents a punching bah which is attackable, but is indestructible
 */
class PunchingBag : Entity("Punching Bag"), Attackable {
    override fun tick() {
        println("$type sways.")
    }

    override fun takeHit(strength: Int) {
        println("Despite being hit, $this is as strong as ever.")
    }
}

interface Attackable {
    /**
     * Take a hit with strength [strength]
     */
    fun takeHit(strength: Int)
}

abstract class Block(type: String) : Entity(type) {
    override fun tick() {
        // Blocks don't do anything.
    }
}

class Sand : Block("Sand")

abstract class LivingEntity(
    type: String,
    maxHearts: Int,
    val attackStrength: Int,
) : Entity(type), Attackable {
    var numHearts = maxHearts

    val isAlive
        get() = numHearts > 0

    fun attack(victim: Attackable) {
        println("$this attacks $victim.")
        victim.takeHit(this.attackStrength)
    }

    override fun takeHit(damage: Int) {
        val actualDamage = if (damage > numHearts) numHearts else damage
        numHearts -= actualDamage
        val text = if (actualDamage == 1) "heart" else "hearts"
        println(
            "$this took $actualDamage $text of damage and now has " +
                    "$numHearts $text."
        )
        if (!isAlive) {
            println("$this is now dead.")
        }
    }
}

class Player : LivingEntity("Steve", 20, 5) {
    override fun tick() {
        entities.forEach {
            if (it is Mob && it.isAggressive) {
                this.attack(it)
            } else if (it is Attackable && it !is LivingEntity) {
                this.attack(it)
            }
        }
    }
}

abstract class Mob(
    type: String,
    maxHearts: Int,
    val behavior: Behavior,
    attackStrength: Int,
) : LivingEntity(type, maxHearts, attackStrength) {
    enum class Behavior { Passive, Hostile }

    val isAggressive
        get() = numHearts > 0 && behavior == Behavior.Hostile

    override fun tick() {
        // For now, mobs just look around.
        if (isAlive) {
            println("$this looks around.")
        }
    }
}

class Chicken : Mob("Chicken", 10, Behavior.Passive, 0)

class Zombie : Mob("Zombie", 20, Behavior.Hostile, 5)

fun tick() {
    // Call every entity's tick method.
    entities.forEach { it.tick() }
}


fun main() {
    (1..5).forEach {
        println("\nTick $it:")
        tick()
    }
}