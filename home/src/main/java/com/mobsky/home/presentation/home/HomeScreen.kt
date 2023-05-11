package com.mobsky.home.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobsky.home.domain.model.GitUser
import com.mobsky.home.presentation.screen_sections.components.ScreenStateView
import com.mobsky.home.presentation.screen_sections.git_user_list.UserListView
import com.mobsky.home.presentation.util.TaskState
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, onClickNavigation: (gitUser: GitUser) -> Unit) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerItem(
                    label = { Text("Teste") },
                    selected = false,
                    onClick = {},
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }
        },
        content = {
            Scaffold(
                modifier = Modifier,
                topBar = { HomeTopBar("Teste", onSearchIconClicked = {
                    scope.launch { drawerState.open() }
                }) },
                content = {  innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        HomeView(viewModel, onClickNavigation)
                    }
                })
        })
}

@Composable
fun HomeView(viewModel: HomeScreenViewModel, onClickNavigation: (gitUser: GitUser) -> Unit) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.taskState == TaskState.NotStarted) {
        viewModel.getUsers()
    }

    ScreenStateView(uiState,
        tryAgainCallBack = { viewModel.getUsers() },
        content = {
            UserListView(
                users = uiState.users,
                onItemClick = { onClickNavigation(it) }
            )
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenHomePreview() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(topBarName: String, onSearchIconClicked: () -> Unit) {

    Surface(shadowElevation = 4.dp) {
        TopAppBar(title = { Text(text = topBarName) },
            navigationIcon = {
                IconButton(onClick = {onSearchIconClicked()}) {
                    Icon(Icons.Filled.Menu, "")
                }
            }
        )
    }
}