import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PokerViewModel : ViewModel() {

    var game by mutableStateOf(PokerGame())
        private set

    init {
        game.startGame()
    }

    fun nextStep() {
        game.openNextCard()
        game.opponentsMakeMove()

        // примушує Compose перемалювати екран
        game = game
    }

    fun newGame() {
        game = PokerGame()
        game.startGame()
    }
}