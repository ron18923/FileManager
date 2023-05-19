package com.example.filemanager.compose.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filemanager.R

@Composable
fun StorageTypeGridBlock(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = modifier
            .background(
                colors.onBackground,
                shape = RoundedCornerShape(15.dp)
            )
            .height(220.dp)
            .padding(10.dp),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(getStorageTypeItems().size) { index ->
            StorageTypeGridItem(storageTypeItem = getStorageTypeItems()[index])
        }
    }
}

@Composable
fun StorageTypeGridItem(
    modifier: Modifier = Modifier,
    storageTypeItem: StorageTypeItem
) {
    Column(
        modifier = modifier
            .background(
                color = colors.surface,
                shape = RoundedCornerShape(10.dp)
            )
            .height(95.dp)
            .clickable(true){}
            .padding(top = 5.dp, bottom = 2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = modifier.fillMaxWidth(0.5f),
            painter = painterResource(id = storageTypeItem.imageId),
            contentDescription = "Storage type Image"
        )
        Spacer(modifier = modifier.height(6.dp))
        Text(
            text = storageTypeItem.fileType,
            color = colors.secondary,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = storageTypeItem.filesCount,
            color = colors.secondary,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

data class StorageTypeItem(
    val imageId: Int,
    val fileType: String,
    val filesCount: String
)

fun getStorageTypeItems() =
    listOf(
        StorageTypeItem(imageId = R.drawable.photo, fileType = "Photo", filesCount = "4325"),
        StorageTypeItem(imageId = R.drawable.video, fileType = "Video", filesCount = "73"),
        StorageTypeItem(imageId = R.drawable.audio, fileType = "Audio", filesCount = "28"),
        StorageTypeItem(imageId = R.drawable.document, fileType = "Document", filesCount = "611"),
        StorageTypeItem(imageId = R.drawable.apk, fileType = "APK", filesCount = "1"),
        StorageTypeItem(imageId = R.drawable.archives, fileType = "Archives", filesCount = "1")
    )