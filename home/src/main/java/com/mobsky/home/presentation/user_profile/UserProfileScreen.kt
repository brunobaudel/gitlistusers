package com.mobsky.home.presentation.user_profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mobsky.home.domain.model.GitUser
import com.mobsky.home.presentation.screen_sections.components.ScreenStateView
import com.mobsky.home.presentation.screen_sections.git_user_list.UserListView
import com.mobsky.home.presentation.screen_sections.git_user_profile_header.UserDetailView
import com.mobsky.home.presentation.util.TaskState

@Composable
fun UserProfileScreen(
    viewModel: UserProfileViewModel,
    onClickNavigation: (gitUser: GitUser) -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.taskState == TaskState.NotStarted)
        viewModel.getUserInfo()

    ScreenStateView(uiState) {
        UserDetailView(user = uiState.user) {
            onClickNavigation.invoke(it)
        }
    }

}
