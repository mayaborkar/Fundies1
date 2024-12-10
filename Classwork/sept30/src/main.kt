fun main() {
    val twentyZeros = Array<Int>(20) { 0 } //makes an array that has 20 0s in it
}

data class Person(
    var firstName: String, var lastName: String
) {
    override fun toString(): String {
        if (lastName == null) {
            firstName
        } else {
            "$firstName $lastName"
        }
    }
}

