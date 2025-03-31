package game

import utility.Vector3
import kotlin.collections.List

class World(val size: Vector3) {
    val snake: Snake
    val obstacles: List<Obstacle>
    val activePoint: Point
}