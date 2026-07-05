package com.sarnavsky.pasz.pokermaster.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircleIcon(icon: ImageVector, circle: Int, size: Int ) {
    Box(
        modifier = Modifier
            .size(circle.dp)
            .clip(CircleShape)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF17771A),
                        Color(0xFF072D08)
                    ),
                    center = Offset(
                        x = 150f,
                        y = 50f
                    )
                ),
                shape = CircleShape
            )

            .border(
                width = 2.dp,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFFDA6A),
                        Color(0xFFE7B700)
                    )
                ),
                shape = CircleShape
            )
            .border(
                width = 4.dp,
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF000000),
                        Color(0xFF012601)
                    )
                ),
                shape = CircleShape
            ),

        contentAlignment = Alignment.Center
    ) {
        val brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFFFDA6A),
                Color(0xFFE7B700)
            )
        )


        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black.copy(alpha = 0.4f),
            modifier = Modifier
                .size(size.dp)
                .offset(x = 0.dp, y = 1.dp)
        )


        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(size.dp)
                .graphicsLayer(alpha = 0.99f)
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            brush = brush,
                            blendMode = BlendMode.SrcIn
                        )
                    }
                }
        )


    }
}