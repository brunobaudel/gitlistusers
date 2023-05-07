package com.mobsky.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mobsky.home.ui.HomeScreen
import com.mobsky.navigation.AppGraph

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        route = AppGraph.homeGraph.ROOT,
        startDestination = AppGraph.homeGraph.HOME
    ) {
        composable(route = AppGraph.homeGraph.HOME) {
            HomeScreen()
        }
    }
}