fun main() {

}

/**
 * @return a count of number of each word in [sentence]
 */
fun countWords(sentence: String): Map<String, Int> {
    val count = mutableMapOf<String, Int>()
    for (word in sentence.split(" ")) {
        // count[word] = (count.get(word) ?: 0) + 1
        count[word] = count.getOrDefault(word, 0) + 1
    }
    return count
}

/**
 * @return the email address String corresponding to [id]
 */

fun getAddressRecord(id: Int, notFoundMessage: String = "Record not found"): String {
    val record = records.get(id)
    if (record == null) {
        return notFoundMessage
    } else {
        val address = StringBuilder()
        if (record.name == null) {
            address.append(record.email)
        } else {
            address.append(record.name)
        }
        address.append(" <${record.email}")
        return address.toString()
    }
}

data class Sandwich(
    val bread: Bread,
    val protein: Protein,
    val sauces: List<Sauce>,
    val toasted: Boolean
) {
    val isVegetarian
        get() = protein.isVegetarian

    fun make() {
        println("Place two slices of $bread onto a tray")
        println("Place $protein on one slice")
        if (toasted) {
            println("Put it in the toaster oven")
        }
        for (sauce in sauces) {
            println("Add $sauce")
        }
    }
}

enum class Bread {
    WHITE, WHEAT, BAGEL
}

enum class Protein {
    TOFU, CHICKEN
}

enum class Sauce {
    MAYO, PESTO, BUTTER
}