package com.mobsky.home.presentation.user_repositories

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mobsky.home.presentation.screen_sections.components.ScreenStateView
import com.mobsky.home.presentation.screen_sections.git_user_profile_header.UserDetailView
import com.mobsky.home.presentation.screen_sections.git_user_repository_list.UserRepositoriesListView
import com.mobsky.home.presentation.util.TaskState

@Composable
fun UserRepositoryScreen(viewModel: UserRepositoryViewModel) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.taskState == TaskState.NotStarted) {
        viewModel.getUserRepositories()
    }

    ScreenStateView(uiState) {
        UserRepositoriesListView(userRepositories = uiState.userRepositories)
    }

}
