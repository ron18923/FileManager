package com.example.filemanager.compose.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filemanager.ui.theme.PieChartColor1
import com.example.filemanager.ui.theme.PieChartColor2

@Composable
fun StorageDataBlock(
    modifier: Modifier = Modifier,
    isCloudStorageState: Boolean,
    cloudStorageStateChange: (Boolean) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(colors.onBackground, shape = RoundedCornerShape(30.dp))
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .background(color = colors.surface, shape = RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .padding(5.dp),
        ) {
            StorageTypeButton(
                text = "Internal",
                modifier = modifier.weight(1f),
                isSelected = !isCloudStorageState
            ) {
                cloudStorageStateChange(false)
            }
            StorageTypeButton(
                text = "Cloud",
                modifier = modifier.weight(1f),
                isSelected = isCloudStorageState
            ) {
                cloudStorageStateChange(true)
            }
        }

        Spacer(modifier = modifier.height(30.dp))

        Box(
            modifier = modifier.fillMaxWidth(0.5f),
            contentAlignment = Alignment.Center
        ) {
            twoValuesPieChart(used = (112).toFloat(), free = (144).toFloat())

            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "54%",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = colors.onBackground
                )
                Text(
                    text = "Used",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = colors.onBackground
                )
            }
        }

        Spacer(modifier = modifier.height(15.dp))

        Row(
            modifier = modifier.fillMaxWidth(0.9f),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = modifier
                        .background(PieChartColor2)
                        .size(13.dp)
                ) {}
                Spacer(modifier = modifier.width(5.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "free",
                        color = colors.secondary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "144GB",
                        color = colors.secondary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = modifier
                        .background(PieChartColor1)
                        .size(13.dp)
                ) {}
                Spacer(modifier = modifier.width(5.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "used",
                        color = colors.secondary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "122GB",
                        color = colors.secondary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun StorageTypeButton(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    selected: () -> Unit,
) {

    TextButton(
        modifier = modifier
            .shadow(
                elevation = if (isSelected) 5.dp else 0.dp,
                shape = RoundedCornerShape(18.dp)
            )
            .background(
                color = if (isSelected) colors.primary else Color.Transparent,
                shape = RoundedCornerShape(18.dp)
            ),
        onClick = {
            selected()
        }) {
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            Text(
                text = text,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = if (isSelected) colors.onBackground else colors.secondary
            )
        }
    }
}