package utility

class Vector3(var x: Int, var y: Int, var w: Int) {
    fun scale(scalar: Int) {
        x = x * scalar
        y = y * scalar
        w = w * scalar
    }

    fun add(vector: Vector3) {
        x = x + vector.x
        y = y + vector.y
        w = w + vector.w
    }

    fun sub(vector: Vector3) {
        x = x - vector.x
        y = y - vector.y
        w = w - vector.w
    }
}