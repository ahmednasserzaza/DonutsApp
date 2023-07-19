package com.fighter.donutsapp.ui.navigation


sealed class DonutAppDestination(val route: String) {
    object Welcome : DonutAppDestination(route = "welcome")
    object Home : DonutAppDestination(route = "home")
    object Details : DonutAppDestination(route = "details")
}
