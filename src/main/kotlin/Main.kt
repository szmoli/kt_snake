import game.Game
import utility.Controller
import utility.View

val game = Game(View.worldSize(), 0.01f)
val view = View(game);
//val controller = Controller(game)

fun main() {
    view.sync()
    view.draw()
}