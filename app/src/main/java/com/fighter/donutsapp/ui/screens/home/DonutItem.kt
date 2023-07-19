package com.fighter.donutsapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.fighter.donutsapp.ui.theme.Gray
import com.fighter.donutsapp.ui.theme.Inter
import com.fighter.donutsapp.ui.theme.PrimaryColor
import com.fighter.donutsapp.ui.theme.White

@Composable
fun DonutItem(state: DonutUiState, id:Int, onClickDonut: (Int) -> Unit) {
    ConstraintLayout(
        modifier = Modifier.size(width = 138.dp, height = 130.dp).clickable { onClickDonut(id) },
    ) {

        val horizontalGuideLine = createGuidelineFromTop(0.2f)
        val donutTextContainer = createRef()
        val imageContainer = createRef()

        Box(
            Modifier
                .constrainAs(imageContainer) {
                    top.linkTo(horizontalGuideLine)
                    bottom.linkTo(horizontalGuideLine)
                }
                .fillMaxWidth()
                .zIndex(3f),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(id = state.donutImage),
                contentDescription = "",
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.Fit
            )
        }

        Column(
            Modifier
                .constrainAs(donutTextContainer) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .size(width = 138.dp, height = 110.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .background(White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                4.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            Text(
                modifier = Modifier,
                text = state.donutTitle,
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                color = Gray
            )
            Text(
                modifier = Modifier,
                text = state.donutPrice,
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold,
                color = PrimaryColor
            )
        }

    }
}

@Preview
@Composable
fun PreviewDonut() {
    DonutItem(DonutUiState() , 0 , {})
}