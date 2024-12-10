import kotlin.random.Random

/**
 * Rolls a single six-sided die.
 *
 * @return a random number in the range 1-6
 */
fun rollDie(): Int {
    // The second argument to nextInt() is the upper bound, which is exclusive,
    // so this will return a number in the range 1-6.
    return Random.nextInt(1, 7)
}

/**
 * Rolls 3 six-sided dice.
 *
 * @return the sum of 3 random numbers in the range 1-6
 */
fun rollThreeDice(): Int {
    return rollDie() + rollDie() + rollDie()
}

/**
 * Rolls a single die having numbers in the range [minValue] to [maxValue]
 * (inclusive).
 *
 * @return a random number in the range [minValue] to [maxValue] (inclusive)
 */
fun rollBiasedDie(minValue: Int, maxValue: Int): Int {
    // TODO("Return a random value in the range minValue to maxValue (inclusive)")
    return(Random.nextInt(minValue, maxValue + 1))

}

/**
 * Rolls 3 dice having numbers in the range [minValue] to [maxValue] (inclusive).
 *
 * @return the sum of 3 random numbers in the range [minValue] to [maxValue]
 */
fun rollThreeBiasedDice(minValue: Int, maxValue: Int): Int {
    //TODO("Return the sum of 3 rolls of dice in the range minValue to maxValue (inclusive)")
    return (rollBiasedDie(minValue, maxValue) + rollBiasedDie(minValue, maxValue) + rollBiasedDie(minValue, maxValue))
}

/**
 * Makes a character with a user-provided name and randomly-selected stats
 * using 3 ordinary six-sided dice.
 *
 * @return a sentence describing the character
 */
fun makeCharacter(): String {
    println("Enter your character's name:")
    val name = readln()
    val charisma = rollThreeDice()
    val agility = rollThreeDice()
    val speed = rollThreeDice()
    return "$name has charisma $charisma, agility $agility, and speed $speed."
}

/**
 * Makes a potentially superior character with a user-provided name and
 * randomly-selected stats using 3 positively biased dice.
 *
 * @return a sentence describing the hero
 */
fun makeHero(): String {
    // Replace this with code to get a hero's name, then generate its
    // characteristics by rolling dice with a range of 3-6 (inclusive).
    // Finally, return the name and characteristics.
    // TODO("Return string describing hero")
    println("Enter your character's name:")
    val name = readln()
    val charisma = rollThreeBiasedDice(3,6)
    val agility = rollThreeBiasedDice(3,6)
    val speed = rollThreeBiasedDice(3,6)
    return ("$name has charisma $charisma, agility $agility, and speed $speed.")
}

/**
 * Makes a character with a user-provided name and randomly-selected stats
 * using 3 dice whose minimum and maximum values are specified by the user.
 *
 * @return a sentence describing the adventurer
 */
fun makeAdventurer(): String {
    // Replace this with code to get an adventurer's name, min die value,
    // and max die value. Generate its characteristics by rolling dice within
    // the specified range. Finally, return the names and characteristics.
    //TODO("Return string describing adventurer")
    println("Enter your character's name:")
    val name = readln()
    println("Enter your character's min die value:")
    var minDie = readln()
    println("Enter your character's max die value:")
    var maxDie = readln()
    val charisma = rollThreeBiasedDice(minDie.toInt(),maxDie.toInt())
    val agility = rollThreeBiasedDice(minDie.toInt(),maxDie.toInt())
    val speed = rollThreeBiasedDice(minDie.toInt(),maxDie.toInt())
    return ("$name has charisma $charisma, agility $agility, and speed $speed.")
}
