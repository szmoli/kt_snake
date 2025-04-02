package game

import utility.ITile
import utility.Vector3

abstract class GameObject(var position: Vector3) : ITile {
    open fun checkCollision(other: GameObject): Boolean {
        return position.x == other.position.x && position.y == other.position.y && position.w == other.position.w
    }
}