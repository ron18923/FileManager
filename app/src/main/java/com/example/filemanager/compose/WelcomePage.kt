package com.example.filemanager.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filemanager.R

@Composable
fun WelcomePage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

//        Spacer(modifier = modifier.height(156.dp))

        Image(
            modifier = modifier
                .width(302.dp)
                .height(245.dp),
            painter = painterResource(id = R.drawable.welcome_page_graphics),
            contentDescription = "Welcome page graphics",
        )

        Spacer(modifier = modifier.height(77.dp))

        Card(
            modifier = modifier
                .width(325.dp)
                .height(273.dp),
            elevation = 0.dp,
            shape = RoundedCornerShape(30.dp),
            backgroundColor = MaterialTheme.colors.onBackground,
        ) {
            Column(
                modifier = modifier.padding(start = 27.dp, end = 27.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = modifier.height(25.dp))

                Text(
                    modifier = modifier,
                    fontSize = 30.sp,
                    color = MaterialTheme.colors.secondary,
                    textAlign = TextAlign.Center,
                    text = "Organise all your files in one place!",
                    fontWeight = FontWeight.ExtraBold,
                )

                Spacer(modifier = modifier.height(6.dp))

                Text(
                    modifier = modifier,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.secondary,
                    textAlign = TextAlign.Center,
                    text = "Keep your files organized more easily and faster in one place ",
                    fontWeight = FontWeight.ExtraBold,
                )

                Spacer(modifier = modifier.height(28.dp))

                Button(modifier = modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                    elevation = ButtonDefaults.elevation(0.dp, pressedElevation = 0.dp),
                    onClick = { /*TODO*/ }) {
                    Text(
                        modifier = modifier.padding(
                            start = 27.dp,
                            end = 27.dp,
                        ),
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.onPrimary,
                        textAlign = TextAlign.Center,
                        text = "Let's Go",
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }

        Spacer(modifier = modifier.height(61.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePagePrev() {
    WelcomePage()
}