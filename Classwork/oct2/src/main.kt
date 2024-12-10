fun main() {
}

data class Gambler(
    val name: String, val winnings: Int?
)

/**
 * @return the sum of the winnings from all gamblers in [gamblers]
 */
fun sumWinnings(gamblers: List<Gambler>): Int {
    var winnings = 0
    for (gambler in gamblers) {
        // winnings = (gambler.winnings)?.plus(winnings) ?: winnings
        winnings += gambler.winnings ?: 0
//    if (gambler.winnings != null){
//        winnings += gambler.winnings // do not take the suggestion of the !!
//    }

    }
    return winnings
}

data class StaffRecord(
    val id: Int, val name: String?, val email: String
)
// type is uppercase

/**
 * @return the email address record for the staff with ID [id]
 */
fun getEmailRecord(id: Int, records: List<StaffRecord>): String {

    var correctRecord: StaffRecord? = null
    for (record in records) {
        if (record.id == id) {
            correctRecord = record
        }
    }
    val formattedRecord = StringBuilder()
    if (correctRecord.name != null) {
        formattedRecord.append(correctRecord.email)
    } else {
        formattedRecord.append(correctRecord.name)
    }
    formattedRecord.append(" <${correctRecord.email}>")
    return formattedRecord.toString()
}

/**
 * @return the number of Strings in [words] which begin with [prefix]
 */

fun countPrefix(words: Set<String>, prefix: String): Int {
    var count = 0
    for (word in words) {
        if (word.startsWith(prefix)) {
            count++
        }
    }
    return count
}

fun numUnique(s: String): Int {
    val nicknames = mapOf(
        "Alexander" to "Alex",
        "Susan" to "Sue",
        "Kian" to "Bin"
    )

    return s.toSet().size // creates a set of characters in s with no repeats


}


fun findNickname(name: String, nickname: Map<String, String>): String {
    return nickname[name] ?: "Name not found"
}