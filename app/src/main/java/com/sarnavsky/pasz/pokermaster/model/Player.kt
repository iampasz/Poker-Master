import com.sarnavsky.pasz.pokermaster.PlayerAction

data class Player(

    val id: Int,

    val name: String,

    val cards: MutableList<PlayingCard> = mutableListOf(),

    var chips: Int = 100,

    var currentBet: Int = 0,

    var folded: Boolean = false,

    var allIn: Boolean = false,

    var isDealer: Boolean = false,

    var isSmallBlind: Boolean = false,

    var isBigBlind: Boolean = false,

    var action: PlayerAction = PlayerAction.NONE
)