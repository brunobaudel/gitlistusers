package com.mobsky.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mobsky.home.presentation.HomeScreen
import com.mobsky.home.presentation.HomeScreenViewModel
import com.mobsky.navigation.AppGraph
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        route = AppGraph.homeGraph.ROOT,
        startDestination = AppGraph.homeGraph.HOME
    ) {
        composable(route = AppGraph.homeGraph.HOME) {
            val viewModel = koinViewModel<HomeScreenViewModel>()
            HomeScreen(viewModel)
        }
    }
}