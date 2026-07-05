package com.sarnavsky.pasz.pokermaster.ui.components

import PlayingCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommunityCards(
    cards: List<PlayingCard>,
    openedCards: Int,
    modifier: Modifier = Modifier
) {


    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            repeat(cards.size) { index ->

                PokerCard(
                    card = cards[index],
                    opened = index < openedCards,
                    modifier = modifier.size(
                        width = 64.dp,
                        height = 90.dp
                    )
                )

            }

        }
    }


}