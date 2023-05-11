package com.mobsky.home.presentation.user_search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mobsky.home.presentation.screen_sections.components.ScreenStateView
import com.mobsky.home.presentation.util.TaskState

@Composable
fun UserSearchScreen(
    viewModel: UserSearchViewModel
) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.taskState == TaskState.NotStarted)
        viewModel.getUserInfo()

    ScreenStateView(uiState) {

    }

}
