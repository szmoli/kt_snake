package game

import utility.Vector3

class Snake(var x: Int, var y: Int) : GameObject(x, y) {
    var direction: Vector3 = Vector3(1, 0, 0)
    var length: Int = 3
}