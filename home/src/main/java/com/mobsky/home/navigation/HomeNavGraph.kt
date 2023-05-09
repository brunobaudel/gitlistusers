package com.mobsky.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.mobsky.home.presentation.home.HomeScreen
import com.mobsky.home.presentation.home.HomeScreenViewModel
import com.mobsky.home.presentation.user_repositories.UserRepositoryScreen
import com.mobsky.home.presentation.user_repositories.UserRepositoryViewModel
import com.mobsky.navigation.AppGraph
import com.mobsky.navigation.HomeGraphArgs
import com.mobsky.navigation.getRouteWithParameters
import com.mobsky.navigation.getRouteWithParametersValue
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        route = AppGraph.homeGraph.ROOT,
        startDestination = AppGraph.homeGraph.HOME
    ) {
        composable(route = AppGraph.homeGraph.HOME) {
            val viewModel = koinViewModel<HomeScreenViewModel>()
            HomeScreen(viewModel) {
                navController.navigate(
                    AppGraph.homeGraph.USER_REPOSITORIES.getRouteWithParametersValue(it.name)
                )
            }
        }
        composable(route = AppGraph.homeGraph.USER_REPOSITORIES
            .getRouteWithParameters(HomeGraphArgs.USER_REPOSITORIES_NAME_PARAM),
            arguments = listOf(
                navArgument(HomeGraphArgs.USER_REPOSITORIES_NAME_PARAM) {
                    type = NavType.StringType
                }
            )
        ) {
            val viewModel = koinViewModel<UserRepositoryViewModel>()
            UserRepositoryScreen(viewModel)
        }
    }
}