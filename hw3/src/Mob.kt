import kotlin.random.Random

// 1. Create a Boolean val property "isAlive" that is true unless numHearts is 0
//    (or, equivalently, status == Status.Dead). It should have a custom getter
//    like the existing status property.
//
//    Create a new function "testIsAlive" that tests isAlive with every possible
//    status value (i.e., Healthy, Injured, and Dead). Uncomment the call to
//    testIsAlive() in runTests().
//
//    Run the tests and ensure they pass before proceeding.
//
// 2. Minecraft mobs can be Passive, Hostile, Neutral, or Boss.
//    * Passive mobs do not attack the player under any circumstances.
//    * Neutral mobs attack the player only if they were attacked first.
//    * Hostile and Boss mobs always attack the player.
//    (My instructions take priority over actual Minecraft rules, in case of
//    conflict.)
//
//    Create a Boolean val property "isAggressive" with a custom getter.
//    * It should always be true for a living Mob whose behavior is Hostile or
//      Boss.
//    * It should never be true for a mob whose behavior is Passive.
//    * If a mob is Neutral, it should be false until the Mob has been attacked,
//      after which it becomes true until it dies.
//    * Dead mobs always have an isAggressive value of false.
//    You must use "when" in your custom getter.
//
//    Add a new function "testIsAggressive" that covers every relevant
//    combination. For example, you would need two tests for a Boss Mob: one
//    when it is alive (when isAggressive should be true) and one when it is
//    dead (when isAggressive should be false). You will need more cases for
//    Neutral Mobs, which go from false to true (when attacked) to false (when
//    dead).
//
//    Call testIsAggressive() from runTests(). Ensure that all tests pass
//    before proceeding.
//
// 3. Add properties minDamage and maxDamage (both Int) to the Mob constructor.
//    They specify how much damage the Mob can do to the player. You will have
//    to change all calls to the Mob constructor to include these values.
//
// 4. Complete the method attack(), as described below in the code. Note that
//    if there is a call to zombie.attack(skeleton), the zombie would be
//    attacking the skeleton.
//
//    Add a new test function, "testAttack". Because attack() has some randomness,
//    your tests will have to use a range of values. For example, if a skeleton
//    that can do 1-3 hearts of damage attacks a zombie that starts with 20 hearts,
//    you could check if the zombie's number of hearts is 17-19 after a single attack.
//    Call testAttack() from runTests(), and make sure all tests pass before proceeding.
//
// 5. Complete the method battle(), as described below in the code.
//
// 6. Write a function named "doBattle()" outside of the class. It should have
//    no parameters and should create two Mobs and have them fight to the death.
//
//    Modify main() to make it call doBattle(). You may comment out the call
//    to runTests().
//
//    Include a transcript in Summary.md.
//
// 7. If you have extra time and energy, add more functionality. One idea is to
//    create multiple Mobs and have them battle in pairs until there is only one
//    survivor ("Mob Madness"). You could decide whether their health should be
//    topped off between battles.
//
//    Don't change any of the methods you implemented for the required parts of
//    the assignment.
//
//    There is no extra credit. This is just for fun and possible prizes.

/**
 * A Minecraft mob.
 * @property type the type (species)
 * @property maxHearts the maximum health level
 * @property behavior the mob's behavior (Passive, Hostile, Neutral, or Boss)
 */
class Mob(
    val type: String,
    val maxHearts: Int,
    val behavior: Behavior,
    val minDamage: Int,
    val maxDamage: Int
) {
    enum class Behavior { Passive, Hostile, Neutral, Boss }

    enum class Status { Healthy, Injured, Dead }

    var numHearts = maxHearts
        private set

    val status
        get() =
            when (numHearts) {
                maxHearts -> Status.Healthy
                0 -> Status.Dead
                else -> Status.Injured
            }

    override fun toString() = type

    /**
     * Takes up to [damage] hearts of damage, to a maximum of [numHearts],
     * printing a message with the amount of damage taken and the
     * resulting [status].
     */
    fun takeDamage(damage: Int) {
        val actualDamage = if (damage > numHearts) numHearts else damage
        numHearts -= actualDamage
        val text = if (actualDamage == 1) "heart" else "hearts"
        println("The $type took $actualDamage $text of damage.")
        println("It is now $status.")
    }

    /**
     * Attacks [victim], doing between [minDamage] and[maxDamage]
     * (inclusive) hearts of damage.
     *
     * @throws IllegalArgumentException unless [isAggressive]
     */

    /**
     * first check by using the require method to check if IsAgressive is true
     *
     * then creates a value which is called damage that will store the amount of damage that will be done
     * to the victim, this value is inputted by the user with minDamage and MaxDamage
     *
     * at the end, the victim takes that random amount of damage in that range
     */
    fun attack(victim: Mob) {
        // First, use require() to ensure that this Mob's isAggressive
        // property is true.
        //
        // If so, select a random number between minDamage and maxDamage
        // (including those values) and make the victim take that much
        // damage. For example, if minDamage was 3 and maxDamage was 5,
        // this would do 3, 4, or 5 hearts of damage.
        require(isAggressive)

        val damage = Random.nextInt(victim.minDamage, victim.maxDamage + 1)
        victim.takeDamage(damage)
    }

    /**
     * Simulates a battle to the death with [opponent]. The property
     * [isAggressive] must be true for at least one of them, or neither
     * would damage the other and the fight would never end.
     *
     * @throws IllegalArgumentException if [isAggressive] is false for
     *     both this Mob and its opponent
     */

    /**
     * first the function checks if the opponent or the original victim is aggressive
     *
     * the loop will only continue if the opponent and the original is alive
     * first it checks if the opponent is aggressive, if it is then it attacks the victim
     *
     * if the victim is agressive then it attacks the oppenent
     *
     * finally, the loop ends and it prints out who won
     */
    fun battle(opponent: Mob) {
        // First, use require() to ensure that isAggressive is true
        // for at least one of the two Mobs.
        //
        // This Mob and its opponent take turns. A Mob does nothing
        // during its turn unless it isAggressive, in which case
        // call attack() with the other Mob as its victim.
        //
        // When one of the two Mobs is dead, the winner is announced
        // (printed), and the method ends (returns). Do not use the
        // keywords "break" or "continue" in this method. Do use "while".

        // this requires that either the opponent isAggressive or the other mob is aggressive
        require(opponent.isAggressive || this.isAggressive)

        while (opponent.isAlive && this.isAlive) {
            if (opponent.isAggressive) {
                opponent.attack(this)
            }
            if (this.isAggressive) {
                this.attack(opponent)
            }

        }
        if (opponent.isAlive) {
            println("The ${opponent.toString()} wins the battle")
        } else {
            println("The ${this.toString()} wins the battle")
        }
    }

    /**
     * created a value called isAlive that is false if the number of hearts is less than or equal to 0
     * otherwise this variable will be true
     */
    val isAlive
        get() =
            if (numHearts <= 0) {
                false
            } else {
                true
            }

    /**
     * returns true or false based on the instructions
     *
     */
    val isAggressive
        get() =
            when {
                numHearts > 0 && (behavior == Behavior.Hostile || behavior == Behavior.Boss) -> true
                behavior == Behavior.Passive -> false
                behavior == Behavior.Neutral && status != Status.Injured && status != Status.Dead -> false
                behavior == Behavior.Neutral && status == Status.Injured && status != Status.Dead -> true
                status == Status.Dead -> false
                else -> false
            }
}

/**
 * first we have to make an instance of a mob which I randomly gave a type, maxHeart, behavior
 * --> later on I added the min and max damage because we changed the function
 *
 * I made three different calls to the takeDamage function to test all the cases
 * The first time, I did no damage and so it was healthy, the second time I only did 2 hearts of damage
 * and so it was not dead, but just injured, the last call I ensured numHearts was 0
 */
fun testIsAlive() {
    val mob = Mob("villagers", 8, Mob.Behavior.Neutral, 0, 8)
    println(mob.takeDamage(0)) // status = Healthy
    println(mob.takeDamage(2)) // status = Injured
    println(mob.takeDamage(6)) // status = Dead

}

/**
 * I made one mob that had a boss behavior
 *
 * first I made sure the inital state of the Boos Mob was aggressive, after this I made it take damage
 * and then I checked again to make sure it was false
 *
 *for the neutral mob i ensured it switched from false to true back to false
 */
fun testIsAggressive() {
    val bossMob = Mob("villagers", 8, Mob.Behavior.Boss, 0, 8)
    println(bossMob.isAggressive) // true
    bossMob.takeDamage(8)
    println(bossMob.isAggressive) // false

    val neutralMob = Mob("villagers", 8, Mob.Behavior.Neutral, 0, 8)
    println(neutralMob.isAggressive) // false
    neutralMob.takeDamage(6)
    println(neutralMob.isAggressive) // true
    neutralMob.takeDamage(2)
    println(neutralMob.isAggressive) // false


}


/**
 * made two mobs that attacked each other
 * used assertTrue to ensure the number of hearts after the damage was in the correct range, tried this
 * for different behaviors
 */
fun testAttack() {
    val mob1 = Mob("skeleton", 10, Mob.Behavior.Boss, 1, 3)
    val mob2 = Mob("zombie", 20, Mob.Behavior.Neutral, 1, 10)
    mob1.attack(mob2)
    assertTrue(mob2.numHearts in 17..19) // has to be in this range because the min damage for 20 hearts is 1 and max is 3

    val mob3 = Mob("villagers", 15, Mob.Behavior.Hostile, 5, 10)
    val mob4 = Mob("town man", 8, Mob.Behavior.Passive, 1, 16)
    mob3.attack(mob4)
    assertTrue(mob4.numHearts in 0..3)

    println("All attacks passed")
}

/**
 * made two mobs and made them battle
 */
fun doBattle() {
    val mob1 = Mob("villager", 15, Mob.Behavior.Neutral, 1, 5)
    val mob2 = Mob("creeper", 10, Mob.Behavior.Hostile, 1, 3)
    mob1.battle(mob2)

}

fun main() {
    // runTests()
    doBattle()
}

fun runTests() {
    testIsAlive()
    testIsAggressive()
    testAttack()
}
