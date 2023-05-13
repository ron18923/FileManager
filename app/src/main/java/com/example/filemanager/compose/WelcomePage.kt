package com.example.filemanager.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.filemanager.R

@Composable
fun WelcomePage(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState),
    ) {
        Column(
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth(0.85f)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Bottom
        ) {

            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 156.dp),
                painter = painterResource(id = R.drawable.welcome_page_graphics),
                contentDescription = "Welcome page graphics",
                contentScale = ContentScale.FillWidth
            )

            Card(
                modifier = modifier.padding(top = 72.dp),
                backgroundColor = MaterialTheme.colors.onBackground,
                elevation = 0.dp,
                shape = RoundedCornerShape(30.dp),
            ) {
                Column(modifier = modifier.padding(25.dp)) {
                    Text(
                        modifier = modifier,
                        fontSize = 30.sp,
                        color = MaterialTheme.colors.secondary,
                        textAlign = TextAlign.Center,
                        text = "Organise all your files in one place!",
                        fontWeight = FontWeight.ExtraBold,
                    )

                    Text(
                        modifier = modifier.padding(top = 6.dp),
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.secondary,
                        textAlign = TextAlign.Center,
                        text = "Keep your files organized more easily and faster in one place ",
                        fontWeight = FontWeight.ExtraBold,
                    )

                    Button(modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 26.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                        elevation = ButtonDefaults.elevation(0.dp, pressedElevation = 0.dp),
                        onClick = { /*TODO*/ }) {
                        Text(
                            modifier = modifier.padding(
                                start = 27.dp,
                                end = 27.dp,
                            ),
                            fontSize = 30.sp,
                            color = MaterialTheme.colors.onPrimary,
                            textAlign = TextAlign.Center,
                            text = "Let's Go",
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }

            Spacer(modifier = modifier.height(60.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePagePrev() {
    WelcomePage()
}