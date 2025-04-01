package utility

import game.Game

class View(val game: Game) {
    val columns: Int = System.getenv("COLUMNS").toInt()
    val lines: Int = System.getenv("LINES").toInt()
    val size = columns * lines;

    /**
     * The view buffer stores the characters that represent the game. It's initialized to all blank characters.
     */
    var viewBuffer: CharArray = CharArray(size) {
        ' '
    }

    /**
     * Updates the view buffer based on the game's state.
     */
    fun updateBuffer() {

    }

    /**
     * Prints the content of the viewBuffer to the screen.
     * @see viewBuffer
     */
    fun draw() {

    }

    /**
     * Transforms a viewBuffer index to a world coordinate.
     * @param bufferIndex An index of the viewBuffer
     * @return A Vector3 world position
     * @see viewBuffer
     * @see Vector3
     */
    private fun worldPosition(bufferIndex: Int): Vector3 {
        return Vector3(
            bufferIndex % columns,
            bufferIndex / columns,
            1
        )
    }

    /**
     * Transforms a world coordinate to a viewBuffer index.
     * @param worldPosition A Vector3 world position
     * @return An index into the viewBuffer
     * @see viewBuffer
     * @see Vector3
     */
    private fun bufferIndex(worldPosition: Vector3): Int {
        return worldPosition.y * columns + worldPosition.x
    }
}