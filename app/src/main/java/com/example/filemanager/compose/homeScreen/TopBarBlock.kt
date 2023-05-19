package com.example.filemanager.compose.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filemanager.R

@Composable
fun TopBarBlock(
    modifier: Modifier = Modifier,
    searchText: String,
    onValueChange: (String) -> Unit
) {

    Row(
        modifier = modifier
            .padding(top = 40.dp, bottom = 20.dp)
            .fillMaxWidth()
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(
            modifier = modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .background(color = colors.onBackground, shape = CircleShape),
            onClick = { /*TODO*/ }) {
            Icon(
                modifier = modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .padding(6.dp),
                painter = painterResource(id = R.drawable.baseline_grid_on_24),
                tint = colors.secondary,
                contentDescription = "grid icon"
            )
        }

        BasicTextField(
            value = searchText,
            onValueChange = { onValueChange(it) },
            modifier = modifier
                .background(
                    color = colors.onBackground,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(6.dp)
                .fillMaxWidth(0.5f),
            textStyle = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = colors.secondary
            ),
            decorationBox = {
                Row(
                    modifier = modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search icon",
                        tint = colors.secondary
                    )
                    Spacer(modifier = modifier.width(4.dp))
                    if (searchText.isEmpty()) {
                        Text(
                            text = "search",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.LightGray
                        )
                    }
                    it()
                }
            }
        )

        IconButton(
            modifier = modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .background(color = colors.onBackground, shape = CircleShape),
            onClick = { /*TODO*/ }) {
            Icon(
                modifier = modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .padding(4.dp),
                painter = painterResource(id = R.drawable.outline_person_24),
                tint = colors.secondary,
                contentDescription = "grid icon"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarBlockPrev() {
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
        TopBarBlock(searchText = "") {

        }
    }
}