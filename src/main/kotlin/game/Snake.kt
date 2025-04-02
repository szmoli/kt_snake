package game

import utility.Vector3

/**
 * Constructs a new snake.
 * @param position The position of the snake in the world.
 */
class Snake(position: Vector3) : GameObject(position) {
    override fun tile(worldPosition: Vector3): Char {
        return when (Vector3.equals(body[0], worldPosition)) {
            true -> 'O' // snake head tile
            else -> 'X' // snake body tile
        }
    }

    override fun checkCollision(other: GameObject): Boolean {
        for (bodyPosition in body) {
            if (Vector3.equals(bodyPosition, other.position)) {
                return true
            }
        }

        return false
    }

    fun checkCollision(position: Vector3): Boolean {
        for (bodyPosition in body) {
            if (Vector3.equals(bodyPosition, position)) {
                return true
            }
        }

        return false
    }

    /**
     * Moves the snake in the current direction.
     */
    fun move() {
        // Move body parts from the back to the front.
        for (i in body.size - 1 downTo 1) {
            val previous: Vector3 = body[i - 1]
            body[i].x = previous.x
            body[i].y = previous.y
            body[i].w = previous.w
        }

        // Move the head in the current direction.
        body[0] = body[0].add(direction)
    }

    /**
     * Changes the direction of the snake.
     * @param newDirection The new direction
     */
    fun changeDirection(newDirection: Vector3) {
        direction = newDirection
    }

    /**
     * Grows the snake's length by one.
     */
    fun growLength() {
        val last = body.last()
        val offset: Vector3 = if (body.size == 1) {
            // Use the inverse of the direction as the offset.
            Vector3(direction.x, direction.y, direction.w)
        }
        else {
            // Calculate the offset based on the last two body pieces.
            val secondLast = body[body.size - 2]
            secondLast.sub(last)
        }

        val inverseOffset = offset.scale(-1)
        var newPiece = last.add(inverseOffset)
        body.addLast(newPiece)
    }

    var direction = Vector3(1, 0, 0)
    var body: MutableList<Vector3> = mutableListOf<Vector3>(position)
}