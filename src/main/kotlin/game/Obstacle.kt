package game

import utility.Vector3

class Obstacle(position: Vector3) : GameObject(position) {
    override fun tile(worldPosition: Vector3): Char {
        return '#' // obstacle tile
    }
}