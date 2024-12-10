fun main() {
    val shirt = Shirt(700)
    shirt.addButton(shirt.Button(false))

}

open class Shirt(val size: Int) {
    val buttons = mutableListOf<Button>()

    open fun addButton(button: Button) {
        buttons.add(button)
    }

    // be able to add a button out of the class use inner
    inner class Button(val fancy: Boolean) {

    }
}

// dont use val because it is not a property, only a parameter (from the parent class)
class FormalShirt(size: Int) : Shirt(size) {
    var tie: Tie? = null

    fun createTIe() {
        tie = Tie()
    }

    inner class Tie

    override fun addButton(button: Button) {
        if (button.fancy) {
            super.addButton(button) // copies the super version of the method
            //buttons.add(button)
        }
    }
}