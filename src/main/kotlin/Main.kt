import game.Game
import utility.Controller
import utility.View

val game = Game(View.worldSize(), 0.015f)
val view = View(game);
//val controller = Controller(game)

fun main() {
    while (true) {
        view.sync()
        view.draw()
        Thread.sleep(500)
    }
}