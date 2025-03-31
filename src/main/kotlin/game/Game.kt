package game

import utility.Vector3
import kotlin.collections.List
import kotlin.compareTo
import kotlin.div
import kotlin.math.max
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.rem
import kotlin.times

class Game(val worldSize: Vector3, val obstacleChance: Float) {
    /**
     * Checks whether two GameObjects collide.
     * @param object1 The first GameObject
     * @param object2 The second GameObject
     * @return True if the two GameObjects collide
     */
    fun checkCollision(object1: GameObject, object2: GameObject): Boolean {
        return (object1.position.x == object2.position.x && object1.position.y == object2.position.y)
    }

    /**
     *  Check if the snake is colliding with anything else.
     *  @return The GameObject which collides with the snake
     */
    fun checkSnakeCollision(): GameObject? {
        if (checkCollision(food, snake)) {
            return food;
        }

        for (obstacle in obstacles) {
            if (checkCollision(obstacle, snake)) {
                return obstacle;
            }
        }

        return null
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

    /**
     *  Executes game logic and advances the game state.
     */
    fun tick() {

    }

    /**
     * Generates a piece new food that's not in the center of the world and which isn't overlapping of existing obstacles.
     * @return The new food
     */
    fun newFood(): Food {
        var x: Int
        var y: Int
        var food: Food
        do {
            x = Random.nextInt(worldSize.x)
            y = Random.nextInt(worldSize.y)
            food = Food(Vector3(x, y, 1))
        } while ((x == worldSize.x / 2 && y == worldSize.y / 2) || obstacles.any { checkCollision(it, food) }) // Check for the world center and if there's already an obstacle

        return food
    }

    /**
     * The snake stars from the middle of the world.
     */
    val snake = Snake(Vector3(worldSize.x / 2, worldSize.y / 2, 1))

    /**
     * The food is generated by newFood()
     * @see newFood
     */
    var food: Food = newFood()

    /**
     * The obstacles are generated outside a small circle around the world center. They can't collide with already existing food in the world.
     * @see food
     */
    val obstacles: List<Obstacle> by lazy {
        List<Obstacle?>(worldSize.x * worldSize.y) { index ->
            val x = index % worldSize.x
            val y = index / worldSize.x
            val middleCirclePoint = ((x - worldSize.x / 2) * (x - worldSize.x / 2)) + ((y - worldSize.y / 2) * (y - worldSize.y / 2));
            val biggerDimension = max(worldSize.x, worldSize.y)
            val circleRadius = (biggerDimension * biggerDimension) / 3.0
            val obstacle = Obstacle(Vector3(x, y, 1))

            obstacle.takeIf {
                val collidesWithFood = checkCollision(food, obstacle)
                val outsideMiddleCircle = middleCirclePoint >= circleRadius
                val shouldSpawn = Random.nextFloat() < obstacleChance
                !collidesWithFood && outsideMiddleCircle && shouldSpawn
            }
        }.filterNotNull()
    }
}