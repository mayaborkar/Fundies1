package minecraft

import assertEquals
import assertFalse
import assertTrue

fun main() {
    /*testCountNeutralMobs()
    testGetNumEntitiesPrintedAs()
    testIsBehaviorPresent()
    testGetLivingEntityTypesSortedByX()
    testIsPlayerStrongest()
    testGetStrengthsOfNearbyThreats()
    testGetLocationList()
    testGetBlockNamesBeneathPlacedEntities()
    testGetDescriptionsOfEntitiesAndBlocks()*/
    testGetStrengthsOfNearbyThreats()
    println("All tests passed.")
}

/**
 * Gets a count of the number of neutral mobs on the board.
 */
fun countNeutralMobs(): Int {
    return Game.placedEntities.filter { it is Mob && it.behavior == Mob.Behavior.Neutral }.count()
}

fun testCountNeutralMobs() {
    assertEquals(1, countNeutralMobs())
}

/**
 * Gets the number of entities whose string representation is [printedForm].
 */
fun getNumEntitiesPrintedAs(printedForm: String): Int {
    return Game.placedEntities.filter { it is Mob && it.toString() == printedForm }.count()
}

fun testGetNumEntitiesPrintedAs() {
    assertEquals(1, getNumEntitiesPrintedAs("Zombie"))
    assertEquals(2, getNumEntitiesPrintedAs("Witch"))
    assertEquals(0, getNumEntitiesPrintedAs("Axolotl"))
}

/**
 * Returns whether any mobs have the specified [behavior].
 */
fun isBehaviorPresent(behavior: Mob.Behavior): Boolean {
    return Game.placedEntities.any { it is Mob && it.behavior == behavior }
}

fun testIsBehaviorPresent() {
    assertTrue(isBehaviorPresent(Mob.Behavior.Passive))
    assertFalse(isBehaviorPresent(Mob.Behavior.Boss))
}

/**
 * Gets the type of every [Mob] sorted by increasing x-coordinate.
 */
fun getLivingEntityTypesSortedByX(): List<String> {
    return Game.placedEntities.filterIsInstance<Mob>().sortedBy { Game.getPosition(it).x }.map { it.type }
}

fun testGetLivingEntityTypesSortedByX() {
    val expected = listOf("Witch", "Zombie", "Sheep", "Witch", "Skeleton", "Spider")
    val actual = getLivingEntityTypesSortedByX()
    assertEquals(expected, actual)
}

/**
 * Returns true if [Game.player] has higher [LivingEntity.numHearts] than any
 * other living entity.
 */
fun isPlayerStrongest(): Boolean {
    // Hint: Try to rephrase the requirement to use the word "any" or "all".
    // check if all  the livingEntity numHearts are less than the players numHearts

    return Game.placedEntities.filterIsInstance<LivingEntity>().all { it.numHearts < Game.player.numHearts }
}


fun testIsPlayerStrongest() {
    assertFalse(isPlayerStrongest())
}

/**
 * Gets the attack strength of every aggressive and mob whose distance from
 * [Game.player] is within fighting range. The list is sorted by increasing
 * distance.
 */
fun getStrengths0fNearbyThreats(): List<Int> {
    return Game.placedEntities.filterIsInstance<Mob>()
        .filter { (it.behavior == Mob.Behavior.Hostile) && Game.calculateDistance(it, Game.player) < FIGHTING_RANGE }
        .sortedBy { Game.calculateDistance(it, Game.player) }.map { it.attackStrength }
}

fun testGetStrengthsOfNearbyThreats() {
    val expected = listOf(6, 5)
    val actual = getStrengths0fNearbyThreats()
    assertEquals(expected, actual)
}

/**
 * Returns a list giving the type and location of each living entity on the
 * board, sorted from top to bottom of the board.
 */

fun getLocationList(): List<String> {
    return Game.placedEntities
        .filterIsInstance<LivingEntity>() // Select only living entities
        .sortedBy { Game.getPosition(it).y } // Sort by y-coordinate
        .map { entity ->
            val position = Game.getPosition(entity)
            //returns the name of the entity in a string format
            "${entity::class.simpleName} at (${position.x}, ${position.y})"
        }
}

fun testGetLocationList() {
    val actual = getLocationList()
    val expected =
        listOf(
            "Witch at (1, 1)",
            "Skeleton at (6, 1)",
            "Spider at (7, 2)",
            "Sheep at (3, 3)",
            "Zombie at (2, 4)",
            "Steve at (5, 5)",
            "Witch at (4, 6)",
        )
    assertEquals(expected, actual)
}

/**
 * Gets the string representations of the blocks on which entities are placed.
 * Each string representation should occur no more than once.
 */
fun getBlockNamesBeneathPlacedEntities(): List<String> {
    // You will need to use Game.getBlock() to get the blocks at each entity's
    // position.
    //
    // Game.getBlock() will never return null for placed entities because they
    // are in bounds, but do not use "!!". Find another way to ensure the output
    // is List<String> (and not List<String?>).
    //
    // To get a string representation of an object, call its toString() method.

    return Game.placedEntities
        .map { entity -> Game.getPosition(entity) } // Get the positions of placed entities
        .mapNotNull { position ->
            Game.getBlock(position.x, position.y)?.toString()
        } // Get block names, filtering out nulls
        .toSet() // Use a Set to ensure uniqueness
        .toList() // Convert back to a List
}

/**
 * Returns a list of all entities within a given [radius] from [Game.player].
 * This function can be used to locate nearby entities for strategy or safety.
 *
 * given a [radius] which is the maximum distance from the player to search for nearby entities.
 * @return A list of entities within the specified radius, sorted by distance from the player.
 */

fun getEntitiesInRadius(radius: Double): List<Entity> {
    return Game.placedEntities.filter { entity ->
        Game.calculateDistance(Game.player, entity) <= radius
    }.sortedBy { entity -> Game.calculateDistance(Game.player, entity) }
}


fun testGetEntitiesInRadius() {
    // Place entities in specific locations to have predictable distances.
    Game.place(Witch(), 3, 3)    // Distance is about 2.83
    Game.place(Zombie(), 2, 4)   // Distance  is about 3.16

    assertEquals(emptyList<Entity>(), getEntitiesInRadius(1.0))

    val radius2 = 3.0
    val expected2 = listOf("Witch") // Witch is the only one in radius of 3.0
    assertEquals(expected2, getEntitiesInRadius(radius2).map { it::class.simpleName })

    val radius3 = 4.0
    val expected3 = listOf("Witch", "Zombie") // Both entities should be within radius
    assertEquals(expected3, getEntitiesInRadius(radius3).map { it::class.simpleName })
}

fun testGetBlockNamesBeneathPlacedEntities() {
    val actual = getBlockNamesBeneathPlacedEntities()
    assertEquals(2, actual.size)
    // The strings can be in any order.
    assertTrue(actual.contains("Grass"))
    assertTrue(actual.contains("Sand"))
}

/**
 * Returns an alphabetical list of statements about each entity and the block it
 * is placed on, such as "Axolotl is on Sand at (3, 4)", which would precede
 * "Zombie is on Sand at (2, 2)"
 */
fun getDescriptionsOfEntitiesAndBlocks(): List<String> {
    // Hint: Create a helper function.
    fun generateDescription(entity: Entity): String {
        val position = Game.getPosition(entity)
        val block = Game.getBlock(position.x, position.y)
        requireNotNull(block)
        return "${entity::class.simpleName} is on ${block::class.simpleName} at (${position.x}, ${position.y})"
    }

    // Generate the descriptions for each placed entity and return the sorted list
    return Game.placedEntities.map { generateDescription(it) }.sorted()
}

fun testGetDescriptionsOfEntitiesAndBlocks() {
    val expected =
        listOf(
            "Sheep is on Grass at (3, 3)",
            "Skeleton is on Sand at (6, 1)",
            "Spider is on Sand at (7, 2)",
            "Steve is on Grass at (5, 5)",
            "Witch is on Grass at (1, 1)",
            "Witch is on Grass at (4, 6)",
            "Zombie is on Grass at (2, 4)",
        )
    val actual = getDescriptionsOfEntitiesAndBlocks()
    assertEquals(expected, actual)
}
