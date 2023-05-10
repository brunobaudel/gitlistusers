package com.mobsky.home.presentation.user_repositories

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mobsky.home.presentation.screen_sections.git_user_repository_list.UserRepositoriesListView
import com.mobsky.home.presentation.util.TaskState

@Composable
fun UserRepositoryScreen(viewModel: UserRepositoryViewModel) {

    val uiState by viewModel.uiState.collectAsState()

    viewModel.getUserRepositories()

    when (uiState.taskState) {
        TaskState.Complete -> UserRepositoriesListView(userRepositories = uiState.userRepositories)
        is TaskState.Error -> Unit
        TaskState.InProgress -> Unit
        TaskState.NotStarted -> Unit
    }

}
