import com.sarnavsky.pasz.pokermaster.BotStyle
import com.sarnavsky.pasz.pokermaster.HandResult
import com.sarnavsky.pasz.pokermaster.PlayerAction

data class Player(

    val id: Int,

    val name: String,


    var botStyle: BotStyle = BotStyle.NORMAL,

    val cards: MutableList<PlayingCard> = mutableListOf(),

    var isCurrentTurn: Boolean = false,

    var chips: Int = 500,

    var currentBet: Int = 0,

    var folded: Boolean = false,

    var allIn: Boolean = false,

    var isDealer: Boolean = false,

    var isSmallBlind: Boolean = false,

    var isBigBlind: Boolean = false,

    var action: PlayerAction = PlayerAction.NONE,

    var handResult: HandResult? = null
)