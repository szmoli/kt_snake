import utility.Vector3
import kotlin.test.*

class Vector3Test {
    lateinit var v1: Vector3
    lateinit var v2: Vector3

    @BeforeTest
    fun setup() {
        v1 = Vector3(-1, -3, 0)
        v2 = Vector3(3, 2, 0)
    }

    @Test
    fun addTest() {
        val v = v1.add(v2)
        assertEquals(2, v.x)
        assertEquals(-1, v.y)
        assertEquals(0, v.w)
    }

    @Test
    fun subTest() {
        val v = v2.sub(v1)
        assertEquals(4, v.x)
        assertEquals(5, v.y)
        assertEquals(0, v.w)
    }

    @Test
    fun scaleTest() {
        val v = v1.scale(-1)
        assertEquals(1, v.x)
        assertEquals(3, v.y)
        assertEquals(0, v.w)
    }
}