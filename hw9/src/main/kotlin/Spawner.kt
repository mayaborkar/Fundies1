/**
 * A spawner of any type of [Entity].
 */
class Spawner<T : Entity>(
    private val spawnType: String,
    private val spawn: () -> T,
) : Entity("$spawnType Spawner", "SpawnerOnSand.png") {
    override fun tick() {
    }
}
