fun main() {
    val vec1 = Vector3D(0, 0, 1)
    val vec2 = Vector3D(0, 4, 0)
    println(vec1.crossProduct(vec2))
}

class Vector3D(
    var x: Int,
    var y: Int,
    var z: Int
) {
    var distanceToOrigin = Math.sqrt()
        private set

    fun crossProduct(other: Vector3D): Vector3D {
        Vector3D(
            this.y * other.z - this.z * other.y,
            this.z * other.x - this.x * other.z,
            this.x * other.y - this.y * other.x
        )
    }
}

fun getEmail(): String {
    print("enter an email: ")
    var email = readln()
    while (!validateEmail) {
        print("enter email address: ")
        rmsil = readln()
    }
}
