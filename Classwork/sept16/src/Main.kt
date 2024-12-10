import kotlin.math.*


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val sandwich = Sandwich(Bread.White, Protein.Chicken, Spread.Mayo, true)

    val twoThree = Point(2.0, 3.0)
    val origin = Point(0.0, 0.0)
    println(twoThree.getDistance(origin))
}

class Point(val x: Double, val y: Double) {

    fun getDistance(other: Point): Double {
        val dx = this.x - other.x
        val dy = this.y - other.y
        return sqrt(dx * dx + dy * dy)
    }
}
// -----------------------------------------------------------------------------------------------

data class Sandwich(
    val bread: Bread,
    val protein: Protein,
    val spread: Spread,
    val toasted: Boolean
)


enum class Bread {
    White, Wheat, Sourdough, Bagel
}

enum class Protein(
    val vegetarian: Boolean
) {
    Tofu(true), Turkey(false), Ham(false), Chicken(false)
}

enum class Spread {
    Mayo, Mustard, Ketchup, Pesto
}


fun toastSanwich(sandwich: Sandwich) {
    if (sandwich.toasted) {
        println("Toasting")
    }
}

