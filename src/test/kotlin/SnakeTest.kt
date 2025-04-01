import game.Snake
import utility.Vector3
import kotlin.test.*

class SnakeTest {
    lateinit var snake: Snake

    @BeforeTest
    fun setup() {
        snake = Snake(Vector3(0, 0, 1))
    }

    /**
     * Basic test for the growLength() function.
     */
    @Test
    fun growLengthTest() {
        snake.growLength()
        assertEquals(2, snake.body.size)
        val last1 = snake.body.last()
        assertEquals(-1, last1.x)
        assertEquals(0, last1.y)
        assertEquals(1, last1.w)

        snake.growLength()
        assertEquals(3, snake.body.size)
        val last2 = snake.body.last()
        assertEquals(-2, last2.x)
        assertEquals(0, last2.y)
        assertEquals(1, last2.w)
    }

    /**
     * Basic test for the snake.move() function.
     */
    @Test
    fun moveTest() {
        snake.move()
        assertEquals(1, snake.body[0].x)
        assertEquals(0, snake.body[0].y)
        assertEquals(1, snake.body[0].w)
    }

    /**
     * 1. The snake grows its length twice (the length is 3)
     * 2. The snake changes direction to (0, 1, 0)
     * 3. The snake moves.
     * 4. The snake changes direction to (-1, 0, 0)
     * 5. The snake moves twice.
     * 6. The snake grows its length by one again. (the length is 4)
     */
    @Test
    fun complexMovement() {
        snake.growLength()
        snake.growLength() // Snake length is now 3
        snake.changeDirection(Vector3(0, 1, 0))
        snake.move()
        assertEquals(0, snake.body[0].x)
        assertEquals(1, snake.body[0].y)
        assertEquals(1, snake.body[0].w)

        assertEquals(0, snake.body[1].x)
        assertEquals(0, snake.body[1].y)
        assertEquals(1, snake.body[1].w)

        assertEquals(-1, snake.body[2].x)
        assertEquals(0, snake.body[2].y)
        assertEquals(1, snake.body[2].w) // End of first move.

        snake.changeDirection(Vector3(-1, 0, 0))
        snake.move()
        assertEquals(-1, snake.body[0].x)
        assertEquals(1, snake.body[0].y)
        assertEquals(1, snake.body[0].w)

        assertEquals(0, snake.body[1].x)
        assertEquals(1, snake.body[1].y)
        assertEquals(1, snake.body[1].w)

        assertEquals(0, snake.body[2].x)
        assertEquals(0, snake.body[2].y)
        assertEquals(1, snake.body[2].w) // End of second move.

        snake.move()
        assertEquals(-2, snake.body[0].x)
        assertEquals(1, snake.body[0].y)
        assertEquals(1, snake.body[0].w)

        assertEquals(-1, snake.body[1].x)
        assertEquals(1, snake.body[1].y)
        assertEquals(1, snake.body[1].w)

        assertEquals(0, snake.body[2].x)
        assertEquals(1, snake.body[2].y)
        assertEquals(1, snake.body[2].w) // End of third move.

        snake.growLength()
        assertEquals(1, snake.body[3].x)
        assertEquals(1, snake.body[3].y)
        assertEquals(1, snake.body[3].w) // End of third move.
    }
}