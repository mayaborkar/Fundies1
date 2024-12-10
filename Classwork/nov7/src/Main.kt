fun main() {

}

/**
 * @retrun true if [items] are in nondecreasing order
 */
fun <E : Comparable<E>> isSorted(items: List<E>): Boolean {
    return items.indices.all { it == items.size - 1 || items[it] <= items[it + 1] }
}