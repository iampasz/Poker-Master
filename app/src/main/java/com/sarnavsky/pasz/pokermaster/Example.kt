package com.sarnavsky.pasz.pokermaster

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.book_5
import com.sarnavsky.pasz.pokermaster.ui.components.CircleIcon

@Composable
fun MyExample(
    onBackClick: () -> Unit
) {

    Box {

        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color(0xFF021503), // знизу темний
                            // зверху прозорий
                        )
                    )
                )
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()

                .padding(16.dp)
        ) {

            item {

              CircleIcon(book_5, 50, 30)

                Spacer(Modifier.height(12.dp))

                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color(0xFFFFD54F)
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    text = "ПРАВИЛА ГРИ",
                    color = Color(0xFFFFD54F),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(4.dp))

                Card0()

            }
        }
    }
}

@Composable
fun Card0 (){
    Card(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0C480E),
                        Color(0xFF021503)
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxWidth()
            .drawWithCache {

                val highlightBrush = Brush.radialGradient(
                    colors = listOf(
                        Color(0x3BFFF39A),
                        Color.Transparent
                    ),
                    center = Offset(
                        x = size.width / 2,
                        y = 0f
                    ),
                    radius = size.minDimension * 0.8f
                )
                onDrawWithContent {
                    drawContent()
                    drawRoundRect(
                        brush = highlightBrush
                    )
                }
            }
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFFDA6A),
                        Color(0xFFE7B700)
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 4.dp,
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF000000),
                        Color(0xFF012601)
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            ),

        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                // LEFT
                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                       CircleIcon(book_5, 20, 20)

                        Spacer(Modifier.width(8.dp))

                        Text(
                            text = "Royal Flush",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "The strongest poker hand",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                    Spacer(Modifier.height(12.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        repeat(5) {
                            Image(
                                modifier = Modifier.weight(1f),
                                painter = painterResource(R.drawable.ca),
                                contentDescription = null
                            )
                        }
                    }

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "Royaljjnjnjnjnjn" +
                                "njnjnjnjnjn" +
                                "njnjnjnjnjn Flush",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }

                // RIGHT
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(120.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {

                    PokerOval(
                        modifier = Modifier.size(
                            width = 320.dp,
                            height = 200.dp
                        )
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                                modifier = Modifier.padding(20.dp)
                    ) {
                        repeat(5) {
                            Image(
                                modifier = Modifier.weight(1f),
                                painter = painterResource(R.drawable.c3),
                                contentDescription = null
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            Text(
                text = "Royaljjnjnjnjnjn" +
                        "njnjnjnjnjn" +
                        "njnjnjnjnjn Flush",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview(
    showBackground = true,
    heightDp = 2000
)
@Composable
fun ExamplePreview() {

    MyExample(
        onBackClick = {}
    )

}

@Composable
fun PokerOval(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .size(width = 300.dp, height = 180.dp)
    ) {

        val outerStroke = 6.dp.toPx()
        val innerStroke = 3.dp.toPx()

        // Основний овал
        drawRoundRect(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color(0xFF1DB954), // яскравий зелений центр
                    Color(0xFF0B3D0B), // темно-зелений
                    Color.Black        // чорний край
                ),
                center = center,
                radius = size.minDimension * 0.7f
            ),

            cornerRadius = CornerRadius(
                x = 40.dp.toPx(),
                y = 40.dp.toPx()
            ),
        )

        // Зовнішня темно-золота рамка
        drawRoundRect(
            color = Color(0xFF8B6914),
            style = Stroke(width = outerStroke),
            cornerRadius = CornerRadius(
                x = 80.dp.toPx(),
                y = 80.dp.toPx()
            ),
        )

        // Внутрішня золота рамка
        drawRoundRect(

            color = Color(0xFFFFD700),
            topLeft = Offset(
                outerStroke + 4.dp.toPx(),
                outerStroke + 4.dp.toPx()
            ),
            size = Size(
                size.width - (outerStroke + 4.dp.toPx()) * 2,
                size.height - (outerStroke + 4.dp.toPx()) * 2
            ),
            style = Stroke(width = innerStroke),

            cornerRadius = CornerRadius(
                x = 60.dp.toPx(),
                y = 60.dp.toPx()
            ),


        )
    }
}




