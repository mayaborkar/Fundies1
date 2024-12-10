fun main() {

}

fun move() {
    println("moved")
}

val emptyFunc: () -> Unit = { move() }

fun isEven(n: Int): Boolean = n % 2 == 0

val evenFunc: (Int) -> Boolean = ::isEven

val profs = listOf("Bhalerao", "Monge", "Rollins", "Spertus")


val anyEndsWithE: Boolean = profs.any { it.endsWith("E") }

val allStartWtihFirstHalf: Boolean = profs.all { it.lowercase()[0] < 'm' }