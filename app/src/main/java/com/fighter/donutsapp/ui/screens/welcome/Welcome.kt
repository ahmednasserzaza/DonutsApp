package com.fighter.donutsapp.ui.screens.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fighter.donutsapp.R
import com.fighter.donutsapp.ui.navigation.navigateToHome
import com.fighter.donutsapp.ui.screens.composable.SubTitle
import com.fighter.donutsapp.ui.theme.Black
import com.fighter.donutsapp.ui.theme.Inter
import com.fighter.donutsapp.ui.theme.PinkColor
import com.fighter.donutsapp.ui.theme.PrimaryColor
import com.fighter.donutsapp.ui.theme.PrimaryColor100
import com.fighter.donutsapp.ui.theme.White
import com.fighter.donutsapp.ui.theme.White100

@Composable
fun WelcomeScreen(navController: NavController) {
    WelcomeContent(onClickGetStarted = { navController.navigateToHome() })
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeContent(onClickGetStarted: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize().background(PinkColor)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .basicMarquee(
                    iterations = Int.MAX_VALUE,
                    spacing = MarqueeSpacing(0.dp)
                ),
            painter = painterResource(id = R.drawable.bg_donut),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .fillMaxWidth()
                .aspectRatio(0.5f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(start = 40.dp),
                text = stringResource(R.string.welcome_header),
                color = PrimaryColor,
                fontFamily = Inter,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )
            SubTitle(
                text = stringResource(R.string.welcom_content),
                fontSize = 18,
                color = PrimaryColor100
            )
            Button(
                onClick = { onClickGetStarted() }, modifier = Modifier
                    .padding(40.dp)
                    .fillMaxWidth()
                    .height(67.dp),
                colors = ButtonDefaults.buttonColors(containerColor = White100)
            ) {
                Text(
                    text = "Get Started",
                    color = Black,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            }
        }
    }

}

@Preview
@Composable
fun WelcomePreview() {
    WelcomeScreen(rememberNavController())
}