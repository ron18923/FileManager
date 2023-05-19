package com.example.filemanager.compose.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomActions(modifier: Modifier = Modifier){

    BottomButton(icon = Icons.Default.Lock, text = "Private Safe") {}
    Spacer(modifier = modifier.height(10.dp))
    BottomButton(icon = Icons.Default.Delete, text = "Recently Deleted") {}

}

@Composable
fun BottomButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    text: String,
    click: () -> Unit,
) {

    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp),
        contentPadding = PaddingValues(
            start = 5.dp, top = 6.dp, bottom = 6.dp
        ),
        colors = ButtonDefaults.buttonColors(backgroundColor = colors.primary),
        shape = RoundedCornerShape(13.dp),
        onClick = { click() }) {

        Row(
            modifier = modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "button's icon",
                tint = colors.secondary,
                modifier = modifier
                    .fillMaxHeight()
                    .aspectRatio(1f),
            )

            Spacer(modifier = modifier.width(2.dp))

            Text(
                text = text,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = colors.onPrimary,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    BottomButton(icon = Icons.Default.Lock, text = "Private Safe") {
    }
}