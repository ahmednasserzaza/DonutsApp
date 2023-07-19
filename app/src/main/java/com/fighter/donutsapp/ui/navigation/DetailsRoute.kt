package com.fighter.donutsapp.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fighter.donutsapp.ui.screens.details.DetailsScreen


private val ROUTE = DonutAppDestination.Details.route

fun NavGraphBuilder.detailsRoute(navController: NavController) {
    composable(ROUTE) { DetailsScreen(navController = navController) }
}

fun NavController.navigateToDetails(donutIndex:Int) {
    navigate("$ROUTE/$donutIndex")
}