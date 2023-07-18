package com.fighter.donutsapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import com.fighter.donutsapp.ui.theme.Gray
import com.fighter.donutsapp.ui.theme.Inter
import com.fighter.donutsapp.ui.theme.PrimaryColor
import com.fighter.donutsapp.ui.theme.White

@Composable
fun DonutItem(state: DonutUiState) {
    Box(
        modifier = Modifier.size(width = 138.dp, height = 130.dp),
    ) {
        Box(
            Modifier.fillMaxWidth().zIndex(3f),
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

        Box(Modifier.fillMaxSize() , contentAlignment = Alignment.BottomCenter) {
            Column(
                Modifier
                    .size(width = 138.dp, height = 110.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp,
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
//        Row(
//            Modifier.fillMaxSize(),
//            horizontalArrangement = Arrangement.Center,
//        ) {
//            Image(
//                modifier = Modifier.size(56.dp),
//                painter = painterResource(id = state.donutImage),
//                contentDescription = "",
//                alignment = Alignment.TopCenter,
//                contentScale = ContentScale.Fit
//            )
//        }

    }
}

@Preview
@Composable
fun PreviewDonut() {
    DonutItem(DonutUiState())
}