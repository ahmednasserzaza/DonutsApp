package com.fighter.donutsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun DonutNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = DonutAppDestination.Welcome.route) {
        welcomeRoute(navController)
        homeRoute(navController)
        detailsRoute(navController)
    }
}