const val FIGHTING_RANGE = 3.0

/**
 * A living entity, such as a [Mob] or [Player] in the game.
 */
abstract class LivingEntity(
    type: String,
    imageFileName: String,
    val maxHearts: Int,
    val attackStrength: Int,
) : Entity(type, imageFileName) {
    enum class Status { Healthy, Injured, Dead }

    var numHearts = maxHearts
        private set

    var status = Status.Healthy
        private set
        get() =
            when (numHearts) {
                maxHearts -> Status.Healthy
                0 -> Status.Dead
                else -> Status.Injured
            }

    val isAlive
        get() = status != Status.Dead

    override fun toString() = "$status $type"

    /**
     * Takes up to [damage] hearts of damage, to a maximum of [numHearts],
     * printing a message with the amount of damage taken and the
     * resulting [status].
     */
    fun takeDamage(
        attacker: LivingEntity,
        damage: Int,
    ) {
        val actualDamage = if (damage > numHearts) numHearts else damage
        numHearts -= actualDamage
        val text = if (actualDamage == 1) "heart" else "hearts"
        Game.addText("$type took $actualDamage $text of damage and is now $status.")
        if (status == Status.Dead) {
            this.die()
        }
    }

    /**
     * Attacks [victim], doing [attackStrength] hearts of damage.
     */
    open fun attack(victim: LivingEntity) {
        Game.addText("$type attacked ${victim.type}.")
        victim.takeDamage(this, attackStrength)
    }

    private fun move(deltaX: Int, deltaX: Int) {
        val pos = Game.getPosition(this)

        require(position != null)

        val newX = position.x + deltaX
        val newY = position.y + deltaY


        // requires that the moving right entity is within the map
        require(Game.isWithinBounds(newX, newY))

        if (!Game.isOccupied(newX, newY)) {
            Game.place(this, newX, newY)
        }

    }

    /**
     * Moves right one cell, or stays in the same place, if that cell is
     * occupied by a [LivingEntity] or out of bounds. This should throw
     * [IllegalArgumentException] if this living entity is not on the board.
     */
    fun moveRight() {
        move(1, 0)
    }

    /**
     * Moves left one cell, or stays in the same place, if that cell is
     * occupied by a [LivingEntity] or out of bounds.
     */
    fun moveLeft() {
        move(-1, 0)
    }

    /**
     * Moves up one cell, or stays in the same place, if that cell is
     * occupied by a [LivingEntity] or out of bounds.
     */
    fun moveUp() {
        move(0, -1)
    }

    /**
     * Moves down one cell, or stays in the same place, if that cell is
     * occupied by a [LivingEntity] or out of bounds.
     */
    fun moveDown() {
        move(0, 1)
    }

    /**
     * Moves randomly to an adjacent unoccupied cell. Cells
     * are considered adjacent if they are to the right, left, up,
     * or down (i.e., changing by 1 either the x-coordinate or the
     * y-coordinate but not both).
     */
    fun moveRandomly() {
        val directions = mutableSetOf<Int>()

        while (directions.size < 4) {
            val tryDirection = Random.nextInt(4)

            if (tryDirection !in directions) {
                directions.add(tryDirection)
                when (tryDirection) {
                    0 -> moveLeft()
                    1 -> moveRight()
                    2 -> moveUp()
                    3 -> moveDown()
                }
            }
        }

    }

    /**
     * Tries to move to an adjacent cell closer to [player]. Cells
     * are considered adjacent if they are to the right, left, up,
     * or down (i.e., changing by 1 either the x-coordinate or the
     * y-coordinate but not both). If all closer adjacent cells are
     * occupied, no movement will occur. This should throw
     * [IllegalArgumentException] if this living entity or [player]
     * is not on the board.
     */
    fun moveTowards(player: Player) {
        require(Game.isInBounds(position.x, position, y))

        require(Game.isInBounds(player.position.x, player.position.y))

        val changeX = player.position.x - position.x
        val changeY = player.position.y - position.y

        // Determine which direction to move
        when {
            changeX > 0 -> moveRight()   // Move right if player is to the right
            changeX < 0 -> moveLeft()    // Move left if player is to the left
            changeY > 0 -> moveDown()     // Move down if player is below
            changeY < 0 -> moveUp()       // Move up if player is above
            else -> println("$type is already next to the player.")
        }

    }
}
