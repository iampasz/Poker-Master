package com.sarnavsky.pasz.pokermaster.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.book_5
import com.sarnavsky.pasz.pokermaster.PlayerAction

@Composable
fun ActionPanel(

    actions : List <PlayerAction>,

    onFold: () -> Unit,

    onCheck: () -> Unit,

    onCall: () -> Unit,

    onRaise: () -> Unit,

    onAllIn: () -> Unit

) {

    val isEnabled = PlayerAction.CHECK in actions

    Box {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(26.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xDD111111)
            ),
            border = BorderStroke(2.dp, Color(0xDD111111))
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 34.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                ActionButton(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Close,
                    title = "FOLD",
                    value = "",
                    color = Color.Red,
                    enabled = PlayerAction.FOLD in actions,
                    onFold

                )

                ActionButton(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Check,
                    title = "CHECK",
                    value = "",
                    color = Color.Green,
                    enabled = PlayerAction.CHECK in actions,
                    onCheck
                )

                ActionButton(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Check,
                    title = "CALL",
                    value = "200",
                    color = Color.Cyan,
                    enabled = PlayerAction.CALL in actions,
                    onCall
                )

                ActionButton(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.KeyboardArrowUp,
                    title = "RAISE",
                    value = "400",
                    color = Color(0xFFFF9800),
                    enabled = PlayerAction.RAISE in actions,
                    onRaise
                )

                ActionButton(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Check,
                    title = "ALL-IN",
                    value = "1500",
                    color = Color(0xFFA64DFF),
                    enabled = PlayerAction.ALL_IN in actions,
                    onAllIn
                )

            }

        }


        Card(modifier = Modifier
            .align(Alignment.TopCenter)
            .offset(y = (-18).dp), shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(
            containerColor = Color.Green
        ), border = BorderStroke(2.dp, Color(0xDD111111))) {

            Text(
                "ВАШ ХІД",
                modifier = Modifier.padding(horizontal = 26.dp, vertical = 8.dp),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 18.sp
            )

        }

    }


}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    value: String,
    color: Color,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {

    Card(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,

        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1C1C1C)
        ),
        border = BorderStroke(1.dp, Color.DarkGray)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()

                .padding(vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CircleIcon(book_5, 60, 30)

            Spacer(Modifier.height(8.dp))

            Text(
                title,
                color = color,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )

            Spacer(Modifier.height(4.dp))

            Text(
                value,
                color = Color.White,
                fontSize = 13.sp
            )

        }

    }

}
