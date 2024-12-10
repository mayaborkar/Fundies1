fun main() {
    val rasika = Person()
    println(Person.name)
}

class Person {
    companion object {
        var name = "Rasika"
    }
}//(var name: String)

private const val FREEZING_F = 32.0

class TemperatureConverter {
    companion object {
        fun fToC(fahrenheit: Double): Double {
            return (fahrenheit - FREEZING_F) * 5 / 9
        }
    }
}

class WordFinder {
    companion object {
        val allWords = listOf("a", "aha", "book", "mart")
        fun isPalindrome(word: String): Boolean {
            return word.reversed() == word
        }

        fun isAnidrome(word: String): Boolean {
            return word.reversed() in allWords && !isPalindrome(word)
        }

        fun isIsogram(word: String): Boolean {
            return word.toSet().size == word.length
        }

        fun hasDoubleLetters(word: String): Boolean {
            return word.indices.all {
                it == word.length - 1 ||
                        word[it] != word[it + 1]
            }
        }

        fun play() {
            val criteria = mutableListOf<(String) -> Boolean>()
            val possibleCriteria = listOf(
                "palindome" to ::isPalindrome,
                "anidrome" to ::isAnidrome,
                "isogram" to ::isIsogram,
                "double letter" to ::hasDoubleLetters
            ) // ordered map
            for (userCriteriaOption in possibleCriteria) {
                getUserCriteria(criteria, userCriteriaOption.first, userCriteriaOption.second)
                // first and second to access the different values in a pair
            }
            println(allWords.filter { word -> criteria.all { it(word) } })


        }

        private fun getUserCriteria(
            criteria: MutableList<(String) -> Boolean>,
            criteriaName: String,
            possibleCriteria: (String) -> Boolean
        ) {
            print("Should it be a $criteriaName? ")
            val response = readln().trim()
            if (response == "y") {
                criteria.add(::isPalindrome) // adds function to  a list
                // criteria.add { isPalindrome((it)) }
            } else if (response == "n") {
                criteria.add { !isPalindrome(it) }
            }
        }
    }
}