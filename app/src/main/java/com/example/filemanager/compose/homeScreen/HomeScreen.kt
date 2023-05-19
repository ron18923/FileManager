package com.example.filemanager.compose.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Home(
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf("") }

    var isCloudStorageState by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopBarBlock(modifier = modifier, searchText) {
            searchText = it
        }

        Column(
            modifier = modifier
                .fillMaxWidth(0.8f)
                .height((LocalConfiguration.current.screenHeightDp - 100 - 73).dp) //subtracting the heights with paddings of the other elements.
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StorageDataBlock(modifier, isCloudStorageState) {
                isCloudStorageState = it
            }

            Spacer(modifier = modifier.height(10.dp))

            StorageTypeGridBlock(modifier = modifier)

            Spacer(modifier = modifier.height(10.dp))

            BottomActions(modifier = modifier)

            BottomBar(modifier = modifier)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeInternalPrev() {
    Home()
}