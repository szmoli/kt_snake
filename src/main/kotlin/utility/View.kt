package utility

import game.Game
import game.GameObject

class View(val game: Game) {
    companion object {
        const val COLUMNS = 80
        const val LINES = 24
        const val SIZE = COLUMNS * LINES

        /**
         * Returns the world size.
         * @return World size
         */
        fun worldSize(): Vector3 = Vector3(COLUMNS, LINES, 0)

        /**
         * Transforms a viewBuffer index to a world coordinate.
         * @param bufferIndex An index of the viewBuffer
         * @return A Vector3 world position
         * @see viewBuffer
         * @see Vector3
         */
        fun worldPosition(bufferIndex: Int): Vector3 {
            return Vector3(
                bufferIndex % COLUMNS,
                bufferIndex / COLUMNS,
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
        fun bufferIndex(worldPosition: Vector3): Int {
            return worldPosition.y * COLUMNS + worldPosition.x
        }
    }

    /**
     * The view buffer stores the characters that represent the game. It's initialized to all blank characters.
     */
    var viewBuffer: CharArray = CharArray(SIZE) {
        ' '
    }

    /**
     * Updates the viewBuffer based on the game's state.
     * @see viewBuffer
     */
    fun sync() {
        for (i in 0 ..< SIZE) {
            val worldPosition = worldPosition(i)
            val gameObject = game.objectAt(worldPosition)
            viewBuffer[i] = gameObject?.tile(worldPosition) ?: ' '
        }
    }

    /**
     * Prints the content of the viewBuffer to the screen.
     * @see viewBuffer
     */
    fun draw() {
//        print("\u001B[H")
//        System.out.flush()
        for (i in 0 ..< SIZE) {
            print(viewBuffer[i])
            val worldPosition = worldPosition(i)
            if (worldPosition.x == COLUMNS - 1) {
                print('\n')
            }
        }
    }
}