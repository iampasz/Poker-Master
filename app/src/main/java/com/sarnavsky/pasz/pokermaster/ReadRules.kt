package com.sarnavsky.pasz.pokermaster

import android.media.Image
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.TestCard
import com.example.test.book_5
import com.sarnavsky.pasz.pokermaster.ui.components.CircleIcon
import keyboard_arrow_right

@Composable
fun RulesScreen(
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
                Block1()
                Spacer(Modifier.height(4.dp))
                Block2()
                Spacer(Modifier.height(4.dp))
                Block3()
                Spacer(Modifier.height(4.dp))
                Block4()
            }
        }
    }
}

@Composable
fun Block1() {

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

    )  {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row {

                CircleIcon(book_5, 90, 50)

                Spacer(Modifier.width(12.dp))

                Column {

                    Text(
                        text = "1. Мета гри",
                        color = Color(0xFFFFD54F),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = "Learn all poker hand combinations.",
                        color = Color.White
                    )

                    Spacer(Modifier.height(8.dp))
                }
            }

            Spacer(Modifier.height(16.dp))

        }
    }
}

@Composable
fun Block2() {

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

    )  {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row {

                CircleIcon(book_5, 90, 50)

                Spacer(Modifier.width(12.dp))

                Column {

                    Text(
                        text = "2. Роздача карт",
                        color = Color(0xFFFFD54F),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )



                    Spacer(Modifier.height(8.dp))

                    Text("• Royal Flush", color = Color.White)
                    Text("• Straight Flush", color = Color.White)
                    Text("• Four of a Kind", color = Color.White)
                }
            }

            Spacer(Modifier.height(16.dp))


        }
    }
}

@Composable
fun Block3() {

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

    )  {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row {

                CircleIcon(book_5, 90, 50)

                Spacer(Modifier.width(12.dp))

                Column {

                    Text(
                        text = "3. Раунди ставок",
                        color = Color(0xFFFFD54F),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = "Learn all poker hand combinations.",
                        color = Color.White
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {



                        SmallInfoCard(Modifier.weight(1f), "sss", "ss")
                        SmallInfoCard(Modifier.weight(1f), "sss", "ss")
                        SmallInfoCard(Modifier.weight(1f),  "sss", "ss")
                        SmallInfoCard(Modifier.weight(1f), "sss", "ss")
                        SmallInfoCard(Modifier.weight(1f), "sss", "ss")

                    }

                }
            }

            Spacer(Modifier.height(16.dp))



        }
    }
}

@Composable
fun Block4() {

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

    )  {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row {

                CircleIcon(book_5, 90, 50)

                Spacer(Modifier.width(12.dp))

                Column {

                    Text(
                        text = "1. Мета гри",
                        color = Color(0xFFFFD54F),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = "Learn all poker hand combinations.",
                        color = Color.White
                    )

                    Spacer(Modifier.height(8.dp))
                    Row {

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            FeatureItem("High Card")
                            FeatureItem("Pair")
                            FeatureItem("Two Pair")
                        }

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            FeatureItem("Trips")
                            FeatureItem("Straight")
                            FeatureItem("Flush")
                        }
                    }

                }
            }



        }
    }
}

@Composable
fun RuleCard() {

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

    )  {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row {

                CircleIcon(book_5, 90, 50)

                Spacer(Modifier.width(12.dp))

                Column {

                    Text(
                        text = "1. Мета гри",
                        color = Color(0xFFFFD54F),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = "Learn all poker hand combinations.",
                        color = Color.White
                    )

                    Spacer(Modifier.height(8.dp))

                    Text("• Royal Flush", color = Color.White)
                    Text("• Straight Flush", color = Color.White)
                    Text("• Four of a Kind", color = Color.White)
                }
            }

            Spacer(Modifier.height(16.dp))

            Row {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    FeatureItem("High Card")
                    FeatureItem("Pair")
                    FeatureItem("Two Pair")
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    FeatureItem("Trips")
                    FeatureItem("Straight")
                    FeatureItem("Flush")
                }
            }
        }
    }
}

@Composable
fun FeatureItem(
    text: String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 6.dp)
    ) {

        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = Color(0xFFFFD54F),
            modifier = Modifier.size(18.dp)
        )

        Spacer(Modifier.width(8.dp))

        Text(
            text = text,
            color = Color.White
        )
    }
}

@Composable
fun SmallInfoCard( modifier: Modifier = Modifier, topText: String, middleText: String) {

    Box(
       modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(4.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.Red)
            ){
                Text(
                    text = "Position",
                    color = Color(0xFFFFD54F),
                    fontWeight = FontWeight.Bold
                )
            }


            CircleIcon(book_5, 40, 20)


            Spacer(Modifier.height(1.dp))

            Text(
                text = topText,
                color = Color(0xFFFFD54F),
                fontWeight = FontWeight.Bold
            )

            Text(
                text = middleText,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )

            Spacer(Modifier.height(1.dp))

        }

}


}


@Preview(
    showBackground = true,
    heightDp = 2000
)
@Composable
fun RulesScreenPreview() {

    RulesScreen(
        onBackClick = {}
    )

}

