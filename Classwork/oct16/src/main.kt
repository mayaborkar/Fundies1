fun main() {
    /* val mat1 = arrayOf(arrayOf(1.0, 2.0), arrayOf(3.0, 4.0))
     val mat2 = arrayOf(arrayOf(1.0, 2.0), arrayOf(3.0, 4.0))
     println(sum(mat1, mat2).contentDeepToString())*/

    /*val mini = Cat()
    mini.knead()

    val simba = Lion()
    simba.knead()
    simba.roar()*/

    val unitSquare = Square(1)
    println(unitSquare.area)


}

/**
 * @return the elementwise sum of [mat1] and [mat2]
 * Assume that [mat1] and [mat2] have the same dimensions
 */

fun sum(
    mat1: Array<Array<Double>>,
    mat2: Array<Array<Double>>
): Array<Array<Double>> {
    val numRows = mat1.size
    val numCols = mat1[0].size
    val toReturn = Array(numRows) { Array(numCols) { 0.0 } } // this is how tou create a 2-dimensional array
    for (row in mat1.indices) {
        for (col in mat1[0].indices) {
            toReturn[row][col] = mat1[row][col] + mat2[row][col]
        }
    }
    return toReturn
}

open class Cat : Any() {
    open var clawSharpness = 4

    open val threshold = 5

    override fun toString(): String {
        return "Cat"
    }

    fun knead() {
        println("kneading")
    }

    fun scratchPost() {
        if (clawSharpness > threshold) {
            println("Scratching")
        }
    }
}

open class Lion : Cat() {
    override var clawSharpness = 7

    override val threshold = 10

    fun roar() {
        println("Roar")
    }
}

class HouseCat : Cat() {
    fun purr() {
        println("Purr")
    }
}

open class Rectangle(val length: Int, val width: Int) {
    val area: Int
        get() = length * width
}

class Square(val side: Int) : Rectangle(side, side) {
    val diagonalLength: Double
        get() = side * Math.sqrt(2.0)
}