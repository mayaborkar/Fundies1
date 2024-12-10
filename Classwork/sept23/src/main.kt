fun main() {
    getThreeNames()
}

/**
 * @return true if [email] is a valid email
 * (if it contains "@")
 */
fun isValidEmail(email: String) =
    email.contains("@")

fun getValidEmail(): String {
    var email = ""
    do {
        print("Please enter a valid email: ")
        email = readln()
    } while (!isValidEmail(email))
    /*
    while (!isValidEmail(email)) {
        print("Please enter a valid email: ")
        email = readln()
    }
     */
    return email
}

fun guessingGame(correctNum: Int) {
    do {
        print("Please enter a number: ")
        val guess = readln().toIntOrNull()
    } while (guess != correctNum)
    print("You got the number! ")
}

fun getThreeNames() {
    for (idx in 1..3) {
        print("please enter a name number $idx: ")
        val name = readln()
        println("Hello, $name")
    }
    /*
    var idx = 0
    while (idx < 3){
        print("please enter a name: ")
        val name = readln()
        println("Hello, $name")
        idx++
    }
    */
}

fun isPrime(num: Int): Boolean {
    // if it has factors other than 2 and itself
    // then it's not prime
    for (possibleFactor in 2..num - 1) {
        if (num % possibleFactor == 0) {
            return false
        }
    }
    return true
}

fun countdown(num: Int) {
    for (i in 1..num) {
        println(num - i + 1)
    }
    println("Blastoff")
}