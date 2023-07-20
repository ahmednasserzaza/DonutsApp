package com.fighter.donutsapp.ui.screens.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fighter.donutsapp.R
import com.fighter.donutsapp.ui.theme.Black
import com.fighter.donutsapp.ui.theme.Gray
import com.fighter.donutsapp.ui.theme.Inter
import com.fighter.donutsapp.ui.theme.LightBlue
import com.fighter.donutsapp.ui.theme.PinkColor
import com.fighter.donutsapp.ui.theme.PrimaryColor
import com.fighter.donutsapp.ui.theme.White

@Composable
fun OfferItem(state: OfferUiState, currentIndex: Int, donutName:String , onClickDonut:(String) -> Unit) {
    val backgroundAnimation =
        animateColorAsState(targetValue = if (currentIndex % 2 == 0) LightBlue else PinkColor)

    Box(Modifier.size(width = 220.dp, height = 280.dp)) {
        ConstraintLayout(
            modifier = Modifier.shadow(elevation = 2.dp , shape = RoundedCornerShape(20.dp))
                .clip(shape = RoundedCornerShape(20.dp))
                .background(backgroundAnimation.value)
                .fillMaxHeight().width(200.dp).clickable { onClickDonut(donutName) }

        ) {
            val (favoriteIcon, contentContainer) = createRefs()
            val horizontalGuideLine = createGuidelineFromTop(0.5f)
            Icon(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .clip(shape = CircleShape)
                    .background(White)
                    .constrainAs(ref = favoriteIcon) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .padding(4.dp)
                    .clip(shape = CircleShape),
                painter = painterResource(id = R.drawable.icon_favorite),
                contentDescription = "",
                tint = PrimaryColor
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .constrainAs(contentContainer) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        top.linkTo(horizontalGuideLine)
                    },
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    modifier = Modifier,
                    text = state.offerTittle,
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Black
                )
                Text(
                    modifier = Modifier.fillMaxWidth().padding(end = 8.dp),
                    text = state.offerContent,
                    fontSize = 12.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    color = Gray
                )
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        modifier = Modifier.padding(end = 4.dp),
                        text = "$20",
                        textDecoration = TextDecoration.LineThrough,
                        fontSize = 14.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        color = Gray
                    )
                    Text(
                        modifier = Modifier,
                        text = state.offerPrice,
                        fontSize = 22.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        color = Black
                    )

                }
            }

        }

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 24.dp).offset(x = 16.dp)
                    .size(120.dp),
                painter = painterResource(state.offerDonutImage),
                contentDescription = "",
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Fit
            )
        }
    }

}