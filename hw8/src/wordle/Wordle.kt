package wordle

import assertEquals
import assertThrows
import java.lang.IllegalArgumentException

class WordleGame(
    val secretWord: String,
) {
    /**
     * Returns a string of the same length as [guess] and [secretWord]
     * indicating how closely they match. In positions where the characters are
     * the same, the string will hold '*'. In positions where the character in
     * the guess appears elsewhere in the secret word, the string will hold '+'.
     * In positions where the character in the guess is not in the secret word,
     * the string will hold '.'
     *
     * @throws IllegalArgumentException if the lengths of [guess] and
     * [secretWord] differ or if either contains repeated characters
     */
    fun makeMatchString(guess: String): String {
        require(secretWord.toSet().size == secretWord.length)
        // checks if they are the same length and then checks if there are repeated characters
        require(guess.length == secretWord.length && guess.toSet().size == guess.length)

        return guess.map { char ->
            when {
                secretWord.any { it == char } && guess.indexOf(char) == secretWord.indexOf(char) -> '*'
                secretWord.any { it == char } -> '+'
                else -> '.'
            }
        }.joinToString("")
    }
}

fun main() {
    testMakeMatchString2()
    testMakeMatchString5()
    testMakeMatchStringExceptions()
    println("All tests passed")
}

fun testMakeMatchString2() {
    val game = WordleGame("AB")
    assertEquals("..", game.makeMatchString("CD"))
    assertEquals("**", game.makeMatchString("AB"))
    assertEquals("++", game.makeMatchString("BA"))
    assertEquals("+.", game.makeMatchString("BC"))
}

fun testMakeMatchString5() {
    val game = WordleGame("ABCDE")
    assertEquals(".....", game.makeMatchString("FGHIJ"))
    assertEquals("++*++", game.makeMatchString("EDCBA"))
    assertEquals(".*+++", game.makeMatchString("ZBDEC"))
    assertEquals(".....", game.makeMatchString("FGHIJ"))
    assertEquals("*****", game.makeMatchString("ABCDE"))
}

fun testMakeMatchStringExceptions() {
    val game1 = WordleGame("AABCD")
    assertThrows<IllegalArgumentException> { game1.makeMatchString("ABCDE") }
    val game2 = WordleGame("ABC")
    assertThrows<IllegalArgumentException> { game2.makeMatchString("AXX") }
}
