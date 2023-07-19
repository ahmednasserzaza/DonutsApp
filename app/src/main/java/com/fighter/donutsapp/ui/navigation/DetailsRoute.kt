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
    composable(route = "$ROUTE/{${DonutDetailArgs.DONUT_ID}}",
        arguments = listOf(navArgument(DonutDetailArgs.DONUT_ID) { NavType.IntType })
    ) { DetailsScreen(navController = navController) }
}

fun NavController.navigateToDetails(donutId: Int) {
    navigate("$ROUTE/$donutId")
}

class DonutDetailArgs(savedStateHandle: SavedStateHandle) {
    val donutId: Int = checkNotNull(savedStateHandle[DONUT_ID])

    companion object {
        const val DONUT_ID = "donut"
    }
}