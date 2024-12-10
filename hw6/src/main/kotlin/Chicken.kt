class Chicken :
    Mob(
        "Chicken",
        8,
        Behavior.Passive,
        0,
        "ChickenOnSand.png",
        "chiken.mp3",
        "Chicken clucks",
    )

private var layEggsCounter = 0

/**
 * this is the tick function for the chicken class
 * lays an egg every 10 ticks and this keeps track of the number of eggs layed
 */
override fun tick() {
    layEggsCounter++
    if (layEggsCounter >= 10) { // Lays an egg every 10 ticks
        layEgg()
        layEggsCounter = 0
    }
}

/**
 * @return if the chicken has laid an egg
 * places the egg on the board
 */
private fun layEgg() {
    Game.addText("A chicken has laid an egg!")
    Game.place(Egg(), Game.getPosition(this)?.first ?: return, Game.getPosition(this)?.second ?: return)
}
