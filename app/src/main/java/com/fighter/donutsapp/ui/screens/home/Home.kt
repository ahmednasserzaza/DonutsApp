package com.fighter.donutsapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fighter.donutsapp.R
import com.fighter.donutsapp.ui.navigation.navigateToDetails
import com.fighter.donutsapp.ui.screens.composable.SimpleTitle
import com.fighter.donutsapp.ui.screens.composable.TextTitle
import com.fighter.donutsapp.ui.theme.Black
import com.fighter.donutsapp.ui.theme.Gray
import com.fighter.donutsapp.ui.theme.Inter
import com.fighter.donutsapp.ui.theme.PinkColor
import com.fighter.donutsapp.ui.theme.PrimaryColor
import com.fighter.donutsapp.ui.theme.White100

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), navController: NavController) {
    val state = viewModel.state.collectAsState()
    HomeContent(state.value) { donutName -> navController.navigateToDetails(donutName = donutName) }
}

@Composable
fun HomeContent(state: HomeUiState, onClickDonut: (donutName: String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White100),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                TextTitle(text = "Let's Gonuts!")
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

        SimpleTitle(text = "Today Offers", color = Black)

        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(state.offers) { index, item ->
                OfferItem(state = item, currentIndex =  index , donutName = item.offerTittle , onClickDonut = onClickDonut)
            }
        }

        Text(
            modifier = Modifier.padding(top = 8.dp, start = 16.dp),
            text = "Donuts",
            fontSize = 20.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold,
            color = Black
        )

        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(state.donuts) {index , item ->
                DonutItem(state = item , currentIndex = index , donutName = item.donutTitle , onClickDonut = onClickDonut)
            }
        }
        Box(
            contentAlignment = Alignment.BottomCenter, modifier = Modifier
                .fillMaxHeight(1f)
                .padding(bottom = 24.dp)
        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .aspectRatio(1f)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    modifier = Modifier.size(36.dp),
                    painter = painterResource(id = R.drawable.icon_home),
                    contentDescription = "", tint = PrimaryColor
                )
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.icon_heart),
                    contentDescription = "", tint = PrimaryColor
                )
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.icon_notification),
                    contentDescription = "", tint = PrimaryColor
                )
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.icon_buy),
                    contentDescription = "", tint = PrimaryColor
                )
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.icon_user),
                    contentDescription = "", tint = PrimaryColor
                )

            }
        }

    }


}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen(navController = rememberNavController())
}