package com.sarnavsky.pasz.pokermaster.ui.components

import PlayingCard
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sarnavsky.pasz.pokermaster.R

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween

import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.runtime.getValue

@Composable
fun PokerCard(
    card: PlayingCard,
    opened: Boolean,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    val rotation by animateFloatAsState(
        targetValue = if (opened) 180f else 0f,
        animationSpec = tween(
            durationMillis = 450
        ),
        label = ""
    )


    val painter = painterResource(
        id = if (rotation <= 90f) {
            R.drawable.back
        } else {
            CardImageMapper.getResId(context, card)
        }
    )


    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
            .size(
                width = 32.dp,
                height = 45.dp
            )
            .graphicsLayer {

                rotationY =
                    if (rotation <= 90f)
                        rotation
                    else
                        rotation - 180f

                cameraDistance = 12f * density

            }
    )


}

@Preview(showBackground = true)
@Composable
fun PokerCardPreview() {

    PokerCard(
        card = PlayingCard(
            suit = Suit.SPADES,
            rank = Rank.ACE
        ),
        opened = true
    )
}

