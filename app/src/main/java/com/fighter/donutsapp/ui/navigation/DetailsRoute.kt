package com.fighter.donutsapp.ui.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fighter.donutsapp.ui.screens.details.DetailsScreen


private val ROUTE = DonutAppDestination.Details.route

fun NavGraphBuilder.detailsRoute(navController: NavController) {
    composable(route = "$ROUTE/{${DonutDetailArgs.DONUT_INDEX}}",
        arguments = listOf(navArgument(DonutDetailArgs.DONUT_INDEX) { NavType.IntType })
    ) { DetailsScreen(navController = navController) }
}

fun NavController.navigateToDetails(donutIndex: Int) {
    navigate("$ROUTE/$donutIndex")
}

class DonutDetailArgs(savedStateHandle: SavedStateHandle) {
    val donutIndex: Int = checkNotNull(savedStateHandle[DONUT_INDEX])

    companion object {
        const val DONUT_INDEX = "donut"
    }
}