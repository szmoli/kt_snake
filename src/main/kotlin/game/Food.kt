package game

import utility.Vector3

class Food(position: Vector3) : GameObject(position) {
    override fun tile(worldPosition: Vector3): Char {
        return 'a' // food tile
    }
}