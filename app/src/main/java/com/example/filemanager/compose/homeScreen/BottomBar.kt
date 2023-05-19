package com.example.filemanager.compose.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.filemanager.R

@Composable
fun BottomBar(modifier: Modifier = Modifier){
    TopShadow()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(62.dp)
            .padding(bottom = 5.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(
            modifier = modifier
                .fillMaxHeight()
                .aspectRatio(1f),
            onClick = { /*TODO*/ }) {
            Image(
                modifier = modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .padding(6.dp),
                painter = painterResource(id = R.drawable.recent_file),
                contentDescription = ""
            )
        }
        IconButton(
            modifier = modifier
                .fillMaxHeight()
                .aspectRatio(1f),
            onClick = { /*TODO*/ }) {
            Image(
                modifier = modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .padding(6.dp),
                painter = painterResource(id = R.drawable.file),
                contentDescription = ""
            )
        }
    }
}

@Composable
fun TopShadow(alpha: Float = 0.1f, height: Dp = 6.dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black.copy(alpha = alpha),
                    )
                )
            )
    )
}