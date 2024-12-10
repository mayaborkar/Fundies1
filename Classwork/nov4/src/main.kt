import kotlin.random.Random

fun main() {

}

/**
 * @return a String representing the elements in [list]
 * omitting a random 10%
 */
fun <T> evilToString(list: List<T>): String {
    return list.filter { Random.nextInt(10) != 0 }.toString()
}

class List2D<T> {
    val items: List<List<T>> = listOf()

    /**
     * @return true if anything in this List2D fits the [pred]
     */
    fun any(pred: (T) -> Boolean): Boolean {
        return items.any { it.any  (pred) }
    }

    fun all(pred: (T) -> Boolean): Boolean {
        return items.all { it.all(pred) }

            return !any { !pred(it) }
        }
    }
}

/**
 * @return a String repressenting the positive elements in [list]
 */
fun <T : Number> positiveToString(list: List<T>): String {
    return list.filter { it.toDouble() > 0.0 }.toString()
}