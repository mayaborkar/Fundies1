fun main() {

}

val elephant = Person("Elephant", false)
val cat = Person("Cat", true)
val dog = Person("Dog", false)
val giraffe = Person("Giraffe", false)

val friends = mapOf(
    elephant to setOf(dog, giraffe),
    dog to setOf(elephant),
    giraffe to setOf(cat, elephant),
    cat to setOf(giraffe)
)


class Person(var name: String, var hastadder: Boolean)


fun findLadder(
    person: Person,
    friends: Map<Person, Set<Person>>
): Person? {
    val level1Friends = friends[person]
    if (level1Friends == null) {
        return null
    } else {
        val friendOfFriends = mutableSetOf<Person>()
        for (friend: Person in level1Friends) {
            if (friend.hastadder) {
                return friend
            }
            friendOfFriends.addAll(friends[friend] ?: setOf())
        }
        for (friendOfFriend: Person in friendOfFriends) {
            if (friendOfFriend.hastadder) {
                return friendOfFriend
            }
        }
    }
    return null
}


val recipes: Map<String, Map<String, Int>> = mapOf(
    "cake" to mapOf("flour" to 3, "eggs" to 4, "sugar" to 3),
    "soup" to mapOf("spinach" to 4, "cream" to 3)
)

/**
 * @return the total cost of all ingredients for [meal]
 * according to recipe in [recipes]
 * @return null if [meal] is not in [recipes]
 */

fun totalCost(
    meal: String,
    recipes: Map<String, Map<String, Int>>
): Int? {
    if (meal !in recipes) {
        return null
    } else {
        val recipe = recipes[meal] ?: mapOf() // if recipe is null then we use an empty map
        var cost = 0
        for (ingredient in recipe) {
            cost += ingredient.component2()
            //ingredient: <"eggs" to 4>
        }
        return cost
    }
}

/**
 * @return the index of the smallest element in [arr]
 * Assume [arr] has at least one element
 */
fun indexOfSmallest(arr: Array<Int>): Int {
    var smallest = arr[0]
    var smallestIdx = 0
    for (i in arr.indices) {
        if (arr[i] < smallest) {
            smallest = arr[i]
            smallestIdx = i
        }
    }
    return smallestIdx
}

/**
 * @return the [n]th largest element of [arr]
 * Assume n<arr.size, and n>0
 */
fun nthLargest9arr(arr: Array<Int>, n: Int): Int {
    val nLargest = Array(n) { arr[0] } // n largest numbers in arr
    for (num in arr) {
        // If we find a number > anything in nLargest,
        // it should be added to nLargest,
        // and the minimum in nLargest should be removed
        // If num > minimum in nLargest,
        // replace the minimum of nLargest with the num

        if (num > nLargest.min()) {
            val indexOfSmallest = indexOfSmallest(nLargest)
            nLargest[indexOfSmallest] = num
        }
    }
    return nLargest.min()
}