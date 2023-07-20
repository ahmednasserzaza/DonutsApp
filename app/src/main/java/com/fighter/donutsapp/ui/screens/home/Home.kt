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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fighter.donutsapp.R
import com.fighter.donutsapp.ui.navigation.navigateToDetails
import com.fighter.donutsapp.ui.screens.composable.BottomNavIcon
import com.fighter.donutsapp.ui.screens.composable.BottomNavigation
import com.fighter.donutsapp.ui.screens.composable.HomeDescription
import com.fighter.donutsapp.ui.screens.composable.IconSearch
import com.fighter.donutsapp.ui.screens.composable.SimpleTitle
import com.fighter.donutsapp.ui.screens.composable.TextTitle
import com.fighter.donutsapp.ui.theme.Black
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
            .background(White100)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                TextTitle(text = stringResource(R.string.home_title))
                HomeDescription(text = stringResource(R.string.home_description))
            }
            IconSearch(painter = painterResource(id = R.drawable.search_icon))
        }

        SimpleTitle(text = stringResource(R.string.today_offers), color = Black)

        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(state.donuts) { index, item ->
                OfferItem(
                    state = item,
                    currentIndex = index,
                    donutName = item.donutTitle,
                    onClickDonut = onClickDonut
                )
            }
        }
        SimpleTitle(text = stringResource(R.string.donuts), color = Black)
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(state.donuts) { index, item ->
                DonutItem(
                    state = item,
                    currentIndex = index,
                    donutName = item.donutTitle,
                    onClickDonut = onClickDonut
                )
            }
        }
        BottomNavigation()
    }


}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen(navController = rememberNavController())
}