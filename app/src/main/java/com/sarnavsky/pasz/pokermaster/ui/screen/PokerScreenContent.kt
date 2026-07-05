import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.book_5
import com.sarnavsky.pasz.pokermaster.R
import com.sarnavsky.pasz.pokermaster.ui.components.ActionPanel
import com.sarnavsky.pasz.pokermaster.ui.components.CircleIcon
import com.sarnavsky.pasz.pokermaster.ui.components.CommunityCards
import com.sarnavsky.pasz.pokermaster.ui.components.OpponentArea
import com.sarnavsky.pasz.pokermaster.ui.components.PlayerView
import com.sarnavsky.pasz.pokermaster.ui.screen.GameLayout


@Composable
fun PokerScreenContent(
    game: PokerGame,
    onNewGame: () -> Unit
) {

    val myCards =
        game.players[0].cards +
                game.tableCards.take(game.openedCards)



    val handResult = PokerHandEvaluator.evaluate(myCards)

    GameLayout(

        top = {

            Text(
                text = "Poker Simulator"
            )

            Column {

                Button(
                    onClick = {
                        onNewGame()
                    }
                ) {
                    Text("NEW GAME")
                }

                Button(
                    onClick = {
                        game.openNextCard()
                    },
                    enabled = game.playerMoved
                ) {
                    Text("NEXT")
                }

            }




        },

        center = {


//
//            PokerTable(
//                pot = game.pot
//            ) {
//
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//
//                    PotView(game.pot)
//
//                    Spacer(Modifier.height(16.dp))
//
//                    Row(
//                        horizontalArrangement = Arrangement.spacedBy(8.dp)
//                    ) {
//
//                        CommunityCards(
//                            cards = game.tableCards,
//                            openedCards = game.openedCards
//                        )
//
//                    }
//
//                }
//            }

            OpponentArea(
                players = game.players,
                gameFinished = game.gameFinished
            )

                       CommunityCards(
                            cards = game.tableCards,
                            openedCards = game.openedCards
                        )

            if (game.gameFinished) {

                Text("SHOWDOWN")
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                PlayerView(
                    player = game.players[0],
                    showCards = true,
                    R.drawable.player0
                )
            }



            Text(
                text = "Combination: ${handResult.rank}"
            )

        },

        bottom = {



//            Row {
//
//                game.players[0].cards.forEach {
//
//                    Card(
//                        modifier = Modifier
//                            .size(
//                                width = 60.dp,
//                                height = 90.dp
//                            )
//                            .padding(4.dp)
//                    ) {
//
//                        Box(
//                            contentAlignment = Alignment.Center
//                        ) {
//
//                            PokerCard(
//                                card = it,
//                                opened = true
//                            )
//
//
//                        }
//                    }
//                }
//            }


//
//            Text(
//                text = "You: ${game.players[0].action}"
//            )
//
//            Text(
//                text = "Chips: ${game.players[0].chips}"
//            )

            
//            Button(
//                onClick = {
//                    game.openNextCard()
//                },
//                enabled = game.playerMoved
//            ) {
//                Text("NEXT")
//            }

//            game.players.drop(1).forEach {
//
//                Text(
//                    text = "${it.name}: ${it.action}"
//
//
//                )
//
//                PokerCard(
//                    card = game.tableCards[0],
//                    opened = true
//                )
//
//            }



            ActionPanel(



                onFold = {
                    game.playerFold()
                    game.openNextCard()
                },

                onCheck = {
                    game.playerCheck()
                    game.openNextCard()
                },

                onCall = {
                    game.playerCall()
                    game.openNextCard()
                },

                onRaise = {
                    game.playerRaise()
                    game.openNextCard()
                },

                onAllIn = {
                    game.playerAllIn()
                    game.openNextCard()
                }

            )



//            @Composable
//            fun ActionButton(
//                modifier: Modifier,
//                icon: AttachMoney,
//                title: String,
//                value: String,
//                color: Color
//            ) {
//                TODO("Not yet implemented")
//            }

//            game.players.drop(1).forEach {
//
//                Text(
//                    text = "${it.name} | ${it.action} | Chips: ${it.chips}"
//                )
//            }


//
//            val allHands =
//                CardCombinations.fiveCardHands(myCards)
//
//            Text(
//                text = "Hands: ${allHands.size}"
//            )

            if (game.gameFinished) {
                // показати справжні карти
            } else {
                // показати сорочку карти або "?"
            }

//            game.players.drop(1).forEach { player ->
//
//                Text(player.name)
//
//                Row {
//
//                    player.cards.forEach {
//
//                        Text(
//                            if (game.gameFinished)
//                                it.rank.name
//                            else
//                                "?"
//                        )
//                    }
//                }
//            }
        }

    )
}


@Preview(showBackground = true)
@Composable
fun PokerScreenPreview() {

    val game = PokerGame().apply {
        startGame()
    }

    PokerScreenContent(
        game = game,
        onNewGame = {}
    )
}

