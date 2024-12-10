fun main() {
    performOperation(3, ::addOne)
}

fun sumInt(num: Int): Int {
    if (num == 0) { //base case
        0
    } else { //recursive case
        val digit = num % 10
        val rest = num / 10 //divide by 10 round down
        digit + sumInt(rest)
    }
}

fun isEven(num: Int): Boolean {
    if (num == 0) {
        return true
    } else if (num == 1) {
        return false
    } else {
        return isEven(num - 2)
    }
}

fun addOne(num: Int): Int = num + 1

fun performOperation(
    num: Int,
    operation: (Int) -> Int
) { // second parameter is a function
    print(operation(num))
}