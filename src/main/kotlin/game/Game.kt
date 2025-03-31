package game

import utility.Vector3
import kotlin.collections.List

class Game(val worldSize: Vector3) {
    /**
     * Checks whether two GameObjects collide.
     * @param object1 The first GameObject
     * @param object2 The second GameObject
     * @return True if the two GameObjects collide
     */
    fun checkCollision(object1: GameObject, object2: GameObject): Boolean {

    }

    /**
     *  Check if the snake is colliding with anything else.
     *  @return The GameObject which collides with the snake
     */
    fun checkSnakeCollision(): GameObject {

    }

    /**
     *  Starts the game.
     */
    fun startGame() {

    }

    /**
     *  Ends the game.
     */
    fun endGame() {

    }

//    val snake: Snake
//    val obstacles: List<Obstacle>
//    var food: Food
}