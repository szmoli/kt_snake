package game

import utility.Vector3

/**
 * Constructs a new snake.
 * @param position The position of the snake in the world.
 */
class Snake(position: Vector3) : GameObject(position) {
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
        body[0].add(direction)
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
        length++
    }

    var length = 1
    var direction = Vector3(1, 0, 0)
    var body: MutableList<Vector3> = mutableListOf<Vector3>(position)
}