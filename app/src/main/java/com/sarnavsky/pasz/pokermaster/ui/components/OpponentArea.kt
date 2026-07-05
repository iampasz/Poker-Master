package com.sarnavsky.pasz.pokermaster.ui.components

import Player
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.sarnavsky.pasz.pokermaster.R

@Composable
fun OpponentArea(
    players: List<Player>,
    gameFinished: Boolean
) {

    val playerAvatars = listOf(
        R.drawable.player1,
        R.drawable.player2,
        R.drawable.player3,
        R.drawable.player4,
        R.drawable.player5,
        R.drawable.player6,
    )

    val shuffledAvatars = playerAvatars.shuffled()

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            PlayerView(
                player = players[1],
                showCards = gameFinished,
                shuffledAvatars[0]
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            PlayerView(
                player = players[2],
                showCards = gameFinished,
                shuffledAvatars[1]
            )

            PlayerView(
                player = players[3],
                showCards = gameFinished,
                shuffledAvatars[2]
            )

        }

    }

}