package com.sarnavsky.pasz.pokermaster

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
fun Combinations(
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

                PokerCardItem()

            }
        }
    }
}



@Composable
fun PokerCardItem() {

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

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {


                CircleIcon(book_5, 20,20)

                Spacer(Modifier.width(4.dp))

                CircleIcon(book_5, 20,20)

                Spacer(Modifier.width(4.dp))

                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = "Texas Hold'em",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Most popular poker variation",
                        color = Color.White,
                        fontSize = 12.sp
                    )

                        
                        }


                repeat(5) {

                    Image(
                        painter = painterResource(R.drawable.ca),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(2.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Spacer(Modifier.width(8.dp))


        }
    }
}

@Preview(
    showBackground = true,
    heightDp = 2000
)
@Composable
fun CombinationsPreview() {

    Combinations(
        onBackClick = {}
    )

}
