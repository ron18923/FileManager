package com.example.filemanager.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.filemanager.R
import com.example.filemanager.compose.navigation.Screen

@Composable
fun WelcomePage(modifier: Modifier = Modifier, navController: NavController) {

    val heightDp = LocalConfiguration.current.screenHeightDp.dp.value

    //if screen height is very small, then apply the scrollable interface.
    if (heightDp > 600) {
        Regular(modifier, navController = navController)
    } else Scrollable(modifier, navController = navController)

}

//scrollable composable screen for very small screen heights (for example in split screen mode)
@Composable
fun Scrollable(modifier: Modifier = Modifier, navController: NavController) {

    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
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
                    .padding(top = 50.dp),
                painter = painterResource(id = R.drawable.welcome_page_graphics),
                contentDescription = "Welcome page graphics",
                contentScale = ContentScale.FillWidth
            )

            Card(
                modifier = modifier.padding(top = 72.dp),
                backgroundColor = colors.onBackground,
                elevation = 0.dp,
                shape = RoundedCornerShape(30.dp),
            ) {
                Column(modifier = modifier.padding(25.dp)) {
                    Text(
                        modifier = modifier,
                        fontSize = 30.sp,
                        color = colors.secondary,
                        textAlign = TextAlign.Center,
                        text = "Organise all your files in one place!",
                        fontWeight = FontWeight.ExtraBold,
                    )

                    Text(
                        modifier = modifier.padding(top = 6.dp),
                        fontSize = 18.sp,
                        color = colors.secondary,
                        textAlign = TextAlign.Center,
                        text = "Keep your files organized more easily and faster in one place ",
                        fontWeight = FontWeight.ExtraBold,
                    )

                    Button(modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 26.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colors.primary),
                        elevation = ButtonDefaults.elevation(0.dp, pressedElevation = 0.dp),
                        onClick = {
                            navController.navigate(Screen.HomeInternal.route)
                        }) {
                        Text(
                            modifier = modifier.padding(
                                start = 27.dp,
                                end = 27.dp,
                            ),
                            fontSize = 30.sp,
                            color = colors.onPrimary,
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

//regular composable screen for normal screen heights
@Composable
private fun Regular(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = modifier
            .fillMaxSize(),
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
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.welcome_page_graphics),
                contentDescription = "Welcome page graphics",
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = modifier.fillMaxHeight(0.15f))

            Card(
                modifier = modifier,
                backgroundColor = colors.onBackground,
                elevation = 0.dp,
                shape = RoundedCornerShape(30.dp),
            ) {
                Column(modifier = modifier.padding(25.dp)) {
                    Text(
                        modifier = modifier,
                        fontSize = 30.sp,
                        color = colors.secondary,
                        textAlign = TextAlign.Center,
                        text = "Organise all your files in one place!",
                        fontWeight = FontWeight.ExtraBold,
                        )

                    Text(
                        modifier = modifier.padding(top = 6.dp),
                        fontSize = 18.sp,
                        color = colors.secondary,
                        textAlign = TextAlign.Center,
                        text = "Keep your files organized more easily and faster in one place ",
                        fontWeight = FontWeight.ExtraBold,
                    )

                    Button(modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 26.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colors.primary),
                        elevation = ButtonDefaults.elevation(0.dp, pressedElevation = 0.dp),
                        onClick = {
                            navController.navigate(Screen.HomeInternal.route)
                        }) {
                        Text(
                            modifier = modifier.padding(
                                start = 27.dp,
                                end = 27.dp,
                            ),
                            fontSize = 30.sp,
                            color = colors.onPrimary,
                            textAlign = TextAlign.Center,
                            text = "Let's Go",
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }

            Spacer(modifier = modifier.fillMaxHeight(0.3f))
        }
    }
}

@Composable
fun WelcomePagePrev() {
    WelcomePage(navController = rememberNavController())
}