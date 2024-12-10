import java.util.*
import kotlin.random.Random

fun main() {
    //println("hello")
    //println(Arrays.toString(getRandomArray(4, 3, 8)))
    println(sarcasm("Maya"))
}

/**
 * Creates and returns an array of length [size]
 * full of random numbers between [minRandomNum]
 * and [maxRandomNum]
 */
fun getRandomArray(
    size: Int,
    minRandomNum: Int,
    maxRandomNum: Int
): Array<Int> {
    // arrays don't let us change the size, so we create one of the right size
    // full of zeros (for now)
    val randomNums = Array(size) { 0 }
    for (idx in randomNums.indices) {
        randomNums[idx] = Random.nextInt(
            minRandomNum, maxRandomNum
        )
    }

    return randomNums

}

/**
 * @return the text of [word], with a random half of the letters uppercase and the other half
 * lowercase
 */
fun sarcasm(word: String): String {
    val sarcasticWord = StringBuilder()
    for (char in word) {
        if (Random.nextInt(2) == 0) {
            sarcasticWord.append(char.uppercase())
        } else {
            sarcasticWord.append(char.lowercase())
        }
    }
    return sarcasticWord.toString()
}

fun weirdEmphasis(sentence: String): String {
    val emphasizedSentence = StringBuilder()
    for (word in sentence.split(" ")) {
        emphasizedSentence.append(" ")
        if (Random.nextInt(2) == 0) {
            emphasizedSentence.append(word.uppercase())
        } else {
            emphasizedSentence.append(word.lowercase())
        }
    }
    return emphasizedSentence.toString().substring(1)

}