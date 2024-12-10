/**
 * The player, who is controlled by key presses.
 */
class Player : LivingEntity("Steve", "Steve.png", 20, 6) {
    var lastKeyPressed: String? = null

    /**
     * moves the player based on the key that has been pressed
     * if the player puts a / then it should attack the hostile mobs
     * resets so the last key pressed is null
     */

    override fun tick() {
        // Use a when-statement to decide what to do based on lastKeyPressed.
        // If it is null, do nothing.
        // If it is arrow-right or d, try to move right.
        // If it is arrow-left or a, try to move left.
        // If it is arrow-up or w, try to move up.
        // If it is arrow-down or s, try to move down.
        // If it is space, do nothing.

        when (lastKeyPressed) {
            "arrow-right", "d" -> moveRight()
            "arrow-left", "a" -> moveLeft()
            "arrow-up", "w" -> moveUp()
            "arrow-down", "s" -> moveDown()
            "space" -> { /* do nothing */
            }

            "/" -> attackHostileMobs()
            else -> Game.addText("I don't know how to handle $lastKeyPressed")
        }

        // If it is / (slash), attack all hostile mobs in fighting distance,
        // outputting an appropriate message if there are none.
        // You may find it helpful to use the property Game.placedEntities.

        // Otherwise, output a message saying it couldn't
        // process that character (stating what it was).

        // Finally, set lastKeyPressed to null

        lastKeyPressed = null
    }


    private fun attackHostileMobs() {
        var attackedAny = false
        for (entity in Game.placedEntities) {
            when{
                entity is Mob && entity.behavior == Mob.Behavior.Hositle ->
                {
                    val distance = calculateDistance(this, entity)
                    if (distance <= FIGHTING_RANGE) {
                        attack(entity)
                        attackedAny = true
                    }
            }
        }
        if (!attackedAny) {
            Game.addText("No hostile mobs within fighting range.")
        }
    }


}
