package game

import utility.Vector3

class Obstacle(position: Vector3, val size: Vector3) : GameObject(position) {
    override fun checkCollision(other: GameObject): Boolean {
        return position.x <= other.position.x && position.add(size).x < other.position.x && position.y <= other.position.y && position.add(size).y < other.position.y
    }

    fun checkCollision(worldPosition: Vector3): Boolean {
        val xBetween = position.x <= worldPosition.x && worldPosition.x < position.add(size).x
        val yBetween = position.y <= worldPosition.y && worldPosition.y < position.add(size).y
        return xBetween && yBetween
    }

    override fun tile(worldPosition: Vector3): Char {
        return '#'
    }

    fun debugPrint() {
        for (i in 0 ..< size.x * size.y) {
            print('#')
            if (i % size.x == size.x - 1) {
                print('\n')
            }
        }
    }
}