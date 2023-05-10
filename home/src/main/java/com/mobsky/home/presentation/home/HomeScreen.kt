package com.mobsky.home.presentation.home

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.mobsky.home.domain.model.GitUser
import com.mobsky.home.presentation.screen_sections.git_user_list.UserListView
import com.mobsky.home.presentation.util.TaskState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, onClickNavigation: (gitUser: GitUser) -> Unit) {
    Scaffold(
        content = {
            HomeView(viewModel, onClickNavigation)
        }
    )
}

@Composable
fun HomeView(viewModel: HomeScreenViewModel, onClickNavigation: (gitUser: GitUser) -> Unit) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.taskState == TaskState.NotStarted) {
        viewModel.getUsers()
    }

    when (uiState.taskState) {
        TaskState.Complete -> UserListView(
            users = uiState.users,
            onItemClick = { onClickNavigation(it) }
        )

        is TaskState.Error -> Unit
        TaskState.InProgress -> Unit
        TaskState.NotStarted -> Unit
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenHomePreview() {

}