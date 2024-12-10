
/**
 * Prompts a user to enter their name.
 *
 * @return the text entered by the user
 */
fun getUserName(): String {
    println("What is your name? ")
    val newName = readln()
    return newName
}

/**
 * Greets the user by [name].
 */
fun greetUser(name: String) {
    println("Hello, $name!")
}

/**
 * Carries on a brief conversation with a user.
 */
fun converse() {
    val name = getUserName()
    greetUser(name)
    print("I was doing" + askMajor())
    print(gradYear(askStartYear()))
    print(closeConvo())

}
// Added 1
fun askMajor(): String {
    // asks the user what their major is
    println("What is your major? ")
    // takes in a user input
    val major = readln()
    return major
}
// Ask start year will be used for the graduation year function
fun askStartYear():String {
    // prompts the user to answer what their start year is
    println("What is your start year? ")
    val start = readln()
    // returns their start year
    return start
}

fun gradYear(startYear : String) : String{
    // converts the start year that was inputted into an integer and then adds 4
    val graduationYr = startYear.toInt() + 4
    // prints what the persons graduation year is
    return("Graduation year: " + graduationYr)
}
// prints bye after the convo is finished
fun closeConvo() :String {
    return ("It was nice talking to you, ${getUserName()}!")
}
