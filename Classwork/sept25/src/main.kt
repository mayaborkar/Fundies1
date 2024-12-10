import kotlin.random.Random

fun main() {
    printEveryOtherLetter("Rasika")
    printEveryOtherLetter("hello")
}

fun congratulate() {
    /**
     * Prints "Congratulations!!" ten times
     */
    for (i in 1..10) {
        print("Congratulations!!")
    }
}

fun isValidUSState(state: String) = true

fun getValidUSState() {
    do {
        print("Please enter a US State")
        val state = readln()
    } while (!isValidUSState(state))
}

fun printEveryOtherLetter(word: String) {
    for (idx in 0..word.length - 1 step 2) {
        println(word[idx])
    }
    /*
    for (idx in 0..(word.length / 2.0).roundToInt() - 1) {
        println(word[idx * 2])
    }
     */
}

fun getNames() {

    print("How many names? ")
    val numNames = readln().toInt()
    val allNames = mutableListOf<String>() //creating an empty list (mutable means you can add/remove elements)
    for (i in 1..numNames) {
        print("Please enter name number")
        val name = readln()
        allNames.add(name) // adding the name to the list of strings
    }
    println(allNames)
}


fun sarcasm(word: String): String {
    var sarcastic = ""
    for (char in word) {
        if (Random.nextInt(2) == 0) {
            sarcastic = char.lowercase()
        } else {
            sarcastic = char.uppercase()
        }
    }
    return sarcastic
}

fun weirdEmphasis(sentence: String): String {
    val words = sentence.split(" ")
    val emphasizedWords = mutableListOf<String>()
    for (word in words) {
        if (Random.nextInt(2) == 0) {
            emphasizedWords.add(word.uppercase())
        } else {
            emphasizedWords.add(word.lowercase())
        }
    }
    return emphasizedWords.joinToString { " " }

}