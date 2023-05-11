package com.mobsky.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.mobsky.home.presentation.home.HomeScreen
import com.mobsky.home.presentation.home.HomeScreenViewModel
import com.mobsky.home.presentation.user_profile.UserProfileScreen
import com.mobsky.home.presentation.user_profile.UserProfileViewModel
import com.mobsky.home.presentation.user_repositories.UserRepositoryScreen
import com.mobsky.home.presentation.user_repositories.UserRepositoryViewModel
import com.mobsky.home.presentation.user_search.UserSearchScreen
import com.mobsky.home.presentation.user_search.UserSearchViewModel

import com.mobsky.navigation.HomeGraph
import com.mobsky.navigation.getRouteWithParametersValue

import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        route = HomeGraph.Root().rote,
        startDestination = HomeGraph.Home().rote
    ) {

        composable(route = HomeGraph.Home().rote) {
            val viewModel = koinViewModel<HomeScreenViewModel>()
            HomeScreen(viewModel) {
                navController.navigate(
                    HomeGraph.UserProfile().rote.getRouteWithParametersValue(it.name)
                )
            }
        }

        composable(route = HomeGraph.UserProfile().routeParameters,
            arguments = listOf(
                navArgument(HomeGraph.UserProfile().parameterName) {
                    type = NavType.StringType
                }
            )
        ) {
            val viewModel = koinViewModel<UserProfileViewModel>()
            UserProfileScreen(viewModel) {
                navController.navigate(
                    HomeGraph.UserRepositories().rote.getRouteWithParametersValue(it.name)
                )
            }
        }

        composable(route = HomeGraph.UserRepositories().routeParameters,
            arguments = listOf(
                navArgument(HomeGraph.UserRepositories().parameterName) {
                    type = NavType.StringType
                }
            )
        ) {
            val viewModel = koinViewModel<UserRepositoryViewModel>()
            UserRepositoryScreen(viewModel)
        }

        composable(route = HomeGraph.UserSearch().rote) {
            val viewModel = koinViewModel<UserSearchViewModel>()
            UserSearchScreen(viewModel)
        }
    }
}