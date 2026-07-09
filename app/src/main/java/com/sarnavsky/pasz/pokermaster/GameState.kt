import com.sarnavsky.pasz.pokermaster.model.PokerGame

data class GameState(
    val game: PokerGame = PokerGame(),
    var openedCards: Int = 0
)