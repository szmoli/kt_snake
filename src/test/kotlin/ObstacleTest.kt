import game.Obstacle
import utility.Vector3
import kotlin.test.*

class ObstacleTest {
    lateinit var obstacle: Obstacle

    @BeforeTest
    fun setup() {
        obstacle = Obstacle(Vector3(0, 0, 1), Vector3(2, 2, 0))
    }

    @Test
    fun collisionTrueTest() {
        assertTrue(obstacle.checkCollision(Vector3(0, 0, 1)))
        assertTrue(obstacle.checkCollision(Vector3(0, 1, 1)))
        assertTrue(obstacle.checkCollision(Vector3(1, 0, 1)))
        assertTrue(obstacle.checkCollision(Vector3(1, 1, 1)))
    }

    @Test
    fun collisionFalseTest() {
        assertFalse(obstacle.checkCollision(Vector3(0, -1, 1)))
        assertFalse(obstacle.checkCollision(Vector3(-1, 0, 1)))
        assertFalse(obstacle.checkCollision(Vector3(2, 0, 1)))
        assertFalse(obstacle.checkCollision(Vector3(0, 2, 1)))
    }
}