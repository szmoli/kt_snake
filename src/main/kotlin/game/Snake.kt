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
    public fun move() {

    }

    /**
     * Changes the direction of the snake.
     * @param newDirection The new direction
     */
    public fun changeDirection(newDirection: Vector3) {

    }

    /**
     * Grows the snake's length by one.
     */
    public fun growLength() {

    }

    /**
     * Resets the snake's speed to 1.
     */
    public fun resetSpeed() {

    }

    /**
     * Sets the snake's speed to 2.
     */
    public fun speedUp() {

    }

    private var speed = 1
    private var length = 1
    private var direction = Vector3(1, 0, 0)
    private var body: MutableList<Vector3> = mutableListOf<Vector3>(position)
}