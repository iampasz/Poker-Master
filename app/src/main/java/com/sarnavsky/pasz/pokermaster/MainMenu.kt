package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape


import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.apps
import com.example.test.book_5
import com.example.test.slow_motion_video
import keyboard_arrow_right
import menu_book
import simulation
import java.nio.file.Files.size

import  com.sarnavsky.pasz.pokermaster.R
import com.sarnavsky.pasz.pokermaster.ui.components.CircleIcon
import playing_cards


@Composable
fun TestCard() {

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

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(

                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.width(220.dp),
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    contentScale = ContentScale.Fit

                )
            }


            val goldBrush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF8B5A00),
                    Color(0xFFFFF3B0), // блік
                    Color(0xFFFFC107),
                    Color(0xFF8B5A00)
                )
            )


            Box {
                // тінь
                Text(
                    text = "POKER MASTER",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black.copy(alpha = 0.5f),
                    modifier = Modifier.offset(2.dp, 2.dp)
                )

                // основний текст
                Text(
                    text = "POKER MASTER",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    style = TextStyle(
                        brush = goldBrush
                    )
                )
            }
            Text(
                text = "ТРЕНУЙСЯ • ВЧИСЬ • ПЕРЕМАГАЙ",
                color = Color.White,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(18.dp))

            SimulationCard()


            Spacer(modifier = Modifier.height(8.dp))

            Row {

                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    RulesCard()
                }

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    TemplateCard()
                }


            }

            Spacer(modifier = Modifier.height(8.dp))

            Row {

                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    ReadBook()
                }

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    WatchVideo()
                }

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    MoreApps()
                }


            }


        }


    }

}

@Preview(showBackground = true)
@Composable
fun TestCardPreview() {
    TestCard()
}

@Composable
fun SimulationCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0C480E),
                        Color(0xFF021503)
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            )

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
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFD54F), // золото
                        Color(0xFFB8860B), // темніше золото
                        Color(0xFF4B4B4B)
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


        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircleIcon(menu_book, 60, 30)

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.padding(16.dp),
            ) {

                Text(
                    text = "СИМУЛЯТОР ГРИ",
                    color = Color.White,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Запустити симулятор покеру",
                    color = Color.White,
                    fontSize = 12.sp
                )


                Spacer(modifier = Modifier.height(16.dp))

            }

            Spacer(modifier = Modifier.width(8.dp))

            val brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFFFDA6A),
                    Color(0xFFE7B700)
                )
            )

            Icon(
                imageVector = keyboard_arrow_right,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(30.dp)
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


}

@Composable
fun RulesCard() {

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
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
         CircleIcon(book_5, 60, 30)

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "ПРАВИЛА ГРИ",
                color = Color.White,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Читати правила",
                    color = Color.White,
                    fontSize = 12.sp
                )



                val brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFFDA6A),
                        Color(0xFFE7B700)
                    )
                )

                Icon(
                    imageVector = keyboard_arrow_right,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
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

    }
}

@Composable
fun TemplateCard() {

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
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleIcon(playing_cards, 60, 30)


            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "ПРИКЛАД ГРИ",
                color = Color.White,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Переглянути",
                    color = Color.White,
                    fontSize = 12.sp
                )



                val brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFFDA6A),
                        Color(0xFFE7B700)
                    )
                )

                Icon(
                    imageVector = keyboard_arrow_right,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
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

    }
}

@Composable
fun ReadBook() {

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
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleIcon(book_5, 60, 30)


            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "КНИГА",
                color = Color.White,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
        }
    }
}

@Composable
fun WatchVideo() {

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
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleIcon(slow_motion_video, 60, 30)

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "ВІДЕО",
                color = Color.White,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
        }
    }
}

@Composable
fun MoreApps() {

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
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleIcon(apps, 60, 30)


            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "ДОДАТКИ",
                color = Color.White,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
        }
    }
}





