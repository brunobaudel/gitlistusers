package com.mobsky.home.presentation.home

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import com.mobsky.home.domain.model.GitUser
import com.mobsky.home.presentation.screen_sections.git_user_list.UserListView

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

    LaunchedEffect(true) {
        if (viewModel.uiState.value.taskState == TaskState.NOT_STARTED) {
            viewModel.getUsers()
        }
    }

    UserListView(uiStateFlow = viewModel.uiState) {
        onClickNavigation.invoke(it)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenHomePreview() {

}