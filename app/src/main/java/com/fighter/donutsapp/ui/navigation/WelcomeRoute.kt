package com.fighter.donutsapp.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fighter.donutsapp.ui.screens.welcome.WelcomeScreen

private val ROUTE = DonutAppDestination.Welcome.route

fun NavGraphBuilder.welcomeRoute(navController: NavController) {
    composable(ROUTE) { WelcomeScreen(navController = navController) }
}
