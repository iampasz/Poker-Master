package com.sarnavsky.pasz.pokermaster.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.sarnavsky.pasz.pokermaster.R

@Composable
fun GameLayout(

    top: @Composable () -> Unit,

    center: @Composable () -> Unit,

    bottom: @Composable () -> Unit

) {

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black),
    ) {



        Column(
            modifier = Modifier.fillMaxSize()
        ) {



            Box(
                modifier = Modifier.weight(1f)
            ) {

                Image(
                    painter = painterResource(R.drawable.table),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    center()
                }
            }

            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                bottom()
            }

        }


        Box(

            contentAlignment = Alignment.TopCenter
        ) {
            top()
        }

    }

}