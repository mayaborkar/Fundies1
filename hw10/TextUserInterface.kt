import kotlin.system.exitProcess

class TextUserInterface : UserInterface {
    override fun readGuess(): String {
        // This should prompt the user for a guess, input it,
        // convert it to all capital letters, and return it.
        // You do not need to validate it.
        print("Please enter your guess: ")
        val input = readln()
        return input.uppercase()
    }

    override fun showError(msg: String) {
        // This should print the error message.
        print("Error: $msg")
    }

    override fun showFeedback(guess: String, matchString: String) {
        // This should print the guess and the matchString.
        print("Guess: $guess, Match string: $matchString")
    }

    override fun showLoss(secretWord: String) {
        // This should tell the user what the secret word is.
        print("The secret word is: $secretWord")
    }

    override fun showWin(numGuesses: Int) {
        // Print the appropriate entry from the list
        // WordleGame.WINNING_RESPONSES. For example, if the user guesses
        // the secret word correctly on their first guess, this will print
        // "Genius". If they guess it on their 6th move, this will print "Phew".
        // Do not hardcode the strings or the length of the list.
        // This should not print anything if numGuesses is greater than the
        // length of the list.
        val responses = WordleGame.WINNING_RESPONSES
        for (numGuesses in 1..responses.size) {
            println(responses[numGuesses - 1])
        }
    }
}

fun main(args: Array<String>) {
    val ui = TextUserInterface()
    try {
        val player = if (isHumanPlayer(args)) HumanPlayer(ui) else ArtificialPlayer(ui)
        playGame(player, ui)
    } catch (e: IllegalArgumentException) {
        System.err.println(e.message)
        exitProcess(1)
    }
}