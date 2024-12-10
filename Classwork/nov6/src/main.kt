fun main() {
    val stuff: DataStructure<Int> = SortedList<Int>()
    stuff.add(3)
    stuff.add(3)
    stuff.add(2)
}

interface DataStructure<E> {

    /**
     * Adds [item] to the data structure
     */
    fun add(item: E)

    /**
     * Removes [item] from the data structure
     * @return true if it was successful, or false if the item was not present
     */
    fun remove(item: E): Boolean

    /**
     * @return the number of elements in the data structure
     */
    fun size(): Int
}

class Blob<B> : DataStructure<B> {
    val items = mutableMapOf<B, Int>()
    override fun add(item: B) {
        items[item] = items.getOrDefault(item, 0) + 1
    }

    override fun remove(item: B): Boolean {
        val count = items[item]
        if (count == null) {
            return false
        } else {
            if (count == 1) {
                items.remove(item)
            } else {
                items[item] = count - 1
            }
            return true
        }
    }

    override fun size(): Int {
        return items.values.sum()
    }

    override fun toString(): String {
        var string = ""
        for (item in items) {
            for (count in 1..item.component2()) {
                string += item.component1().toString() + ", "
            }
        }
        return string
    }

}

class SortedList<T : Comparable<T>> : DataStructure<T> {
    val items = mutableListOf<T>()

    override fun add(item: T) {
        val index = items.indexOfFirst { it > item }
        if (index == -1) {
            items.add(item)
        } else {
            items.add(index, item)
        }
    }

    override fun remove(item: T): Boolean {
        if (item in items) {
            items.remove(item)
            return true
        }
        return false
    }

    override fun size(): Int {
        return items.size
    }

}

fun getSupport(things: List<Huggable>) {
    for (thing in things) {
        thing.hug()
    }
}

interface Huggable {
    fun hug()
}

class Cat {
    fun meow() {
        println("meow")
    }

    fun hug() {
        println("cat is hugging you")
    }
}

class Friend(var name: String) {
    fun hug() {
        println("$name is hugging you")
    }
}

class Pillow() {
    fun hug() {
        println("you are higging pillow")
    }
}