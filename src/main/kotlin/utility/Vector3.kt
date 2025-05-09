package utility

class Vector3(var x: Int, var y: Int, var w: Int) {
    fun scale(scalar: Int): Vector3 {
        return Vector3(
            x * scalar,
            y * scalar,
            w * scalar
        )
    }

    fun add(v: Vector3): Vector3 {
        return Vector3(
            x + v.x,
            y + v.y,
            w + v.w
        )
    }

    /**
     * Calculates the vector pointing from this to vector (i.e. result = vector - this)
     * @param vector Where
     */
    fun sub(v: Vector3): Vector3 {
        return Vector3(
            x - v.x,
            y - v.y,
            w - v.w
        )
    }

    companion object {
        fun equals(v1: Vector3, v2: Vector3): Boolean {
            return v1.x == v2.x && v1.y == v2.y && v1.w == v2.w
        }
    }
}