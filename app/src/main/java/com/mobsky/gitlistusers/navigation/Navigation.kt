package com.mobsky.gitlistusers.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mobsky.home.navigation.homeNavGraph
import com.mobsky.navigation.HomeGraph
import com.mobsky.navigation.RootGraph

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = RootGraph.Root().rote,
        startDestination = HomeGraph.Root().rote
    ) {
        homeNavGraph(navController)

    }
}