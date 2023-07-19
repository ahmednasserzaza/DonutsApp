package com.fighter.donutsapp.ui.screens.details

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fighter.donutsapp.R
import com.fighter.donutsapp.ui.screens.composable.CartControl
import com.fighter.donutsapp.ui.screens.composable.SubTitle
import com.fighter.donutsapp.ui.screens.composable.TextTitle
import com.fighter.donutsapp.ui.theme.Black
import com.fighter.donutsapp.ui.theme.Gray
import com.fighter.donutsapp.ui.theme.Inter
import com.fighter.donutsapp.ui.theme.PinkColor
import com.fighter.donutsapp.ui.theme.PrimaryColor
import com.fighter.donutsapp.ui.theme.White
import com.fighter.donutsapp.ui.theme.White100

@Composable
fun DetailsScreen(navController: NavController) {
    DetailsContent()
}

@Composable
fun DetailsContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkColor)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        ) {
            Icon(
                modifier = Modifier.padding(24.dp),
                painter = painterResource(id = R.drawable.icon_back),
                contentDescription = "",
                tint = PrimaryColor
            )
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.details_donut),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
        }
        ConstraintLayout(
        ) {

            val (favorite, card) = createRefs()
            val horizontalGuideLine = createGuidelineFromTop(0.4f)

            Card(modifier = Modifier
                .constrainAs(favorite) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.top)
                }
                .zIndex(1f)
                .padding(end = 32.dp)) {
                Icon(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(White)
                        .padding(4.dp),
                    painter = painterResource(id = R.drawable.icon_favorite),
                    contentDescription = "",
                    tint = PrimaryColor
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .constrainAs(card) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp),
                colors = CardDefaults.cardColors(containerColor = White)
            ) {

                Column(modifier = Modifier.fillMaxSize()) {
                    TextTitle(modifier = Modifier.padding(24.dp), text = "Strawberry Wheel")
                    Text(
                        modifier = Modifier
                            .padding(start = 24.dp),
                        text = "About Gonut",
                        color = Gray,
                        fontFamily = Inter,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp, end = 24.dp, top = 16.dp),
                        text = "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
                        color = Gray,
                        fontFamily = Inter,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 24.dp, vertical = 24.dp),
                        text = "quantity",
                        color = Gray,
                        fontFamily = Inter,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CartControl(text = "-", textColor = Black, backgroundColor = White100)
                        CartControl(text = "1", textColor = Black, backgroundColor = White100)
                        CartControl(text = "+", textColor = White, backgroundColor = Gray)
                    }

                    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.BottomCenter) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp, vertical = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(24.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "$16",
                                color = Black,
                                fontFamily = Inter,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor)
                            ) {
                                Text(
                                    modifier = Modifier.padding(
                                        vertical = 8.dp,
                                        horizontal = 16.dp
                                    ),
                                    text = "Add to cart",
                                    color = White,
                                    fontFamily = Inter,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                }

            }

        }

    }
}

@Preview
@Composable
fun PreviewDetails() {
    DetailsScreen(rememberNavController())
}