package com.fighter.donutsapp

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.fighter.donutsapp.ui.navigation.DonutNavGraph
import com.fighter.donutsapp.ui.theme.PrimaryColor100
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DonutsApp() {
    Scaffold {
        val systemUiController = rememberSystemUiController()
        systemUiController.setStatusBarColor(color = PrimaryColor100)
        val navController = rememberNavController()
        DonutNavGraph(navController = navController)
    }

}


@Preview
@Composable
fun PreviewFood() {
    DonutsApp()
}