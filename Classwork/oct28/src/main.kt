import kotlin.random.Random

fun main() {
    // println(anyInt(listOf(1, 2, 3), { it > 4 }))
    println(sarcasm("hello there"))
}
// allInt returns true if everything in list fits
// allInt returns false if anything in list doesn't fit
// allInt returns false if !any(item)
// allInt returns true

/**
 * @return true if [pred] (item) is true for any item in [nums] and false otherwise
 */
fun anyInt(nums: List<Int>, pred: (Int) -> Boolean): Boolean {
    val notPred = { num: Int -> !pred(num) }
    return !anyInt(nums, notPred)

    /*for (item in nums) {
        if (pred(item)) {
            return true
        }
    }
    return false*/
}

/**
 * @return true if all Strings in [list] contain either ":)" or ":)", and false otherwise
 */
fun allContainSmiles(list: List<String>): Boolean {
    return list.all { it.contains(":)") || it.contains("(:") }
}

fun primesOnly(nums: List<Int>): List<Int> {
    return nums.filter { !(2..it).any { i -> it % i == 0 } }
}

/**
 * @return a verison [text] with a random half of the letters uppercase, and the others lowercase
 */
fun sarcasm(text: String): String {
    return text.map {
        if (Random.nextInt(2) == 0) {
            it.lowercase()
        } else {
            it.uppercase()
        }
    }.joinToString("")
}