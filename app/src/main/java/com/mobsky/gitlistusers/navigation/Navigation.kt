package com.mobsky.gitlistusers.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mobsky.home.navigation.homeNavGraph
import com.mobsky.navigation.AppGraph

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = AppGraph.initial.ROOT,
        startDestination = AppGraph.homeGraph.ROOT
    ) {
        homeNavGraph(navController)
    }
}