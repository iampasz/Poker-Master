package com.sarnavsky.pasz.pokermaster.ui.components

import Player
import PlayingCard
import PokerGame
import PokerScreenContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarnavsky.pasz.pokermaster.PlayerAction
import com.sarnavsky.pasz.pokermaster.R

@Composable
fun PlayerView(
    player: Player,
    showCards: Boolean,
    avatar: Int,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = avatar),
            contentDescription = "Player Avatar",
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(6.dp))

        Text(
            text = player.name,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )

        Spacer(Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            player.cards.forEach {

                PokerCard(
                    card = it,
                    opened = true
                )
            }

        }

        Spacer(Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .background(
                    when (player.action) {
                        PlayerAction.FOLD -> Color(0xFFD32F2F)
                        PlayerAction.CALL -> Color(0xFF1976D2)
                        PlayerAction.CHECK -> Color(0xFF388E3C)
                        PlayerAction.RAISE -> Color(0xFFF57C00)
                        PlayerAction.ALL_IN -> Color(0xFF7B1FA2)
                        else -> Color.DarkGray
                    },
                    RoundedCornerShape(20.dp)
                )
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {

            Text(
                text = player.action.name.replace("_", " "),
                color = Color.White,
                fontSize = 11.sp
            )

        }

        Spacer(Modifier.height(6.dp))

        Text(
            text = "🪙 ${player.chips}",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp
        )

    }

}

@Preview(showBackground = true)
@Composable
fun PlayerViewPreview() {

    val player = Player(
        id = 0,
        name = "You"
    ).apply {
        cards.add(PlayingCard(Suit.SPADES, Rank.ACE))
        cards.add(PlayingCard(Suit.HEARTS, Rank.KING))
        chips = 980
        action = PlayerAction.CALL
    }

    PlayerView(
        player = player,
        showCards = true,
        R.drawable.player1
    )
}

