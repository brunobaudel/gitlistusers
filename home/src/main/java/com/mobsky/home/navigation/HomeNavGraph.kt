package com.mobsky.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mobsky.home.presentation.home.HomeScreen
import com.mobsky.home.presentation.home.HomeScreenViewModel
import com.mobsky.home.presentation.user_repositories.UserRepositoryScreen
import com.mobsky.home.presentation.user_repositories.UserRepositoryViewModel
import com.mobsky.navigation.AppGraph
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        route = AppGraph.homeGraph.ROOT,
        startDestination = AppGraph.homeGraph.HOME
    ) {
        composable(route = AppGraph.homeGraph.HOME) {
            val viewModel = koinViewModel<HomeScreenViewModel>()
            HomeScreen(viewModel) {
                navController.navigate(AppGraph.homeGraph.USER_REPOSITORIES)
            }
        }
        composable(route = AppGraph.homeGraph.USER_REPOSITORIES) {
            val viewModel = koinViewModel<UserRepositoryViewModel>()
            UserRepositoryScreen(viewModel)
        }
    }
}