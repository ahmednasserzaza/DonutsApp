package com.fighter.donutsapp.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fighter.donutsapp.ui.screens.home.HomeScreen


private val ROUTE = DonutAppDestination.Home.route

fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable(route = ROUTE) { HomeScreen(navController = navController) }
}

fun NavController.navigateToHome() {
    navigate(ROUTE)
}

