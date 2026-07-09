package com.sarnavsky.pasz.pokermaster.ui.components

import Player
import PlayingCard
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
fun HeadPlayerView(
    player: Player,
    showCards: Boolean,
    avatar: Int,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


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
                    opened = true,
                    modifier = modifier
                        .size(
                            width = 64.dp,
                            height = 90.dp
                        )
                )
            }

        }

        Spacer(Modifier.height(8.dp))




        if (player.isDealer) {
            Text(
                color = Color.White,

                text = "⭕ ${player.chips}",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
        } else {
            Text(
                color = Color.White,
                text = "🪙 ${player.chips}",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HeadPlayerViewPreview() {

    val player = Player(
        id = 0,
        name = "You"
    ).apply {
        cards.add(PlayingCard(Suit.SPADES, Rank.ACE))
        cards.add(PlayingCard(Suit.HEARTS, Rank.KING))
        chips = 980
        action = PlayerAction.CALL
    }

    HeadPlayerView(
        player = player,
        showCards = true,
        R.drawable.player1
    )
}

