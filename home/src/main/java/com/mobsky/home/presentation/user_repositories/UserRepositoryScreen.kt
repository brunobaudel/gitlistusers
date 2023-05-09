package com.mobsky.home.presentation.user_repositories

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.mobsky.home.presentation.screen_sections.git_user_repository_list.UserRepositoriesListView

@Composable
fun UserRepositoryScreen(viewModel: UserRepositoryViewModel) {

    LaunchedEffect(Unit) {
        viewModel.getUserRepositories()
    }
    UserRepositoriesListView(uiStateFlow = viewModel.uiState)
}
