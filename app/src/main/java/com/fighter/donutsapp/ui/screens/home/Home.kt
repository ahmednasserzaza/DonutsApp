package com.fighter.donutsapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fighter.donutsapp.R
import com.fighter.donutsapp.ui.theme.Black
import com.fighter.donutsapp.ui.theme.Gray
import com.fighter.donutsapp.ui.theme.Inter
import com.fighter.donutsapp.ui.theme.PinkColor
import com.fighter.donutsapp.ui.theme.PrimaryColor
import com.fighter.donutsapp.ui.theme.White
import com.fighter.donutsapp.ui.theme.White100

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState()
    HomeContent(state.value)
}

@Composable
fun HomeContent(state: HomeUiState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White100)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Let's Gonuts!",
                    fontSize = 28.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = PrimaryColor
                )
                Text(
                    text = "Order your favourite donuts from here",
                    fontSize = 14.sp,
                    overflow = TextOverflow.Clip,
                    maxLines = 1,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Gray
                )
            }
            Icon(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(PinkColor)
                    .padding(8.dp),
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = "",
                tint = PrimaryColor
            )

        }

        Text(
            modifier = Modifier.padding(top = 38.dp, start = 24.dp),
            text = "Today Offers",
            fontSize = 20.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold,
            color = Black
        )

        LazyRow(
            contentPadding = PaddingValues(24.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            itemsIndexed(state.offers) { index, item ->
                OfferItem(state = item, index)
            }
        }

        Text(
            modifier = Modifier.padding(top = 24.dp, start = 24.dp),
            text = "Donuts",
            fontSize = 20.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold,
            color = Black
        )

        LazyRow(
            contentPadding = PaddingValues(24.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(state.donuts) {
                DonutItem(state = it)
            }
        }


    }


}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen()
}