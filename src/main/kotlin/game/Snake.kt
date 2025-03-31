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

    }

    /**
     * Changes the direction of the snake.
     * @param newDirection The new direction
     */
    fun changeDirection(newDirection: Vector3) {

    }

    /**
     * Grows the snake's length by one.
     */
    fun growLength() {

    }

    /**
     * Resets the snake's speed to 1.
     */
    fun resetSpeed() {

    }

    /**
     * Sets the snake's speed to 2.
     */
    fun speedUp() {

    }

    var speed = 1
    var length = 1
    var direction = Vector3(1, 0, 0)
    var body: MutableList<Vector3> = mutableListOf<Vector3>(position)
}