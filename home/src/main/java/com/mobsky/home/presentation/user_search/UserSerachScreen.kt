package com.mobsky.home.presentation.user_search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.mobsky.home.domain.model.GitUser
import com.mobsky.home.presentation.screen_sections.components.ScreenStateView
import com.mobsky.home.presentation.screen_sections.components.SearchableTopBar
import com.mobsky.home.presentation.screen_sections.components.SearchableTopBarState
import com.mobsky.home.presentation.screen_sections.git_user_profile_header.UserDetailView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserSearchScreen(
    viewModel: UserSearchViewModel,
    onClickNavigation: (gitUser: GitUser) -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            SearchableTopBar(
                currentSearchText = "Buscar usuario",
                onSearchDispatched = {
                    viewModel.getUserInfo()
                },
                onSearchTextChanged = { searchText ->
                    viewModel.userName.value = searchText
                },
                onSearchDeactivated = {
                    viewModel.setSearchableTopBarState(SearchableTopBarState.Close)
                },
                onSearchIconClicked = {
                    viewModel.setSearchableTopBarState(SearchableTopBarState.Open(""))
                },
                searchableTopBarState = viewModel.searchableTopBarState
            )
        },
        content = { innerPadding ->
            Column(
                modifier = androidx.compose.ui.Modifier.padding(innerPadding)
            ) {
                ScreenStateView(uiState,
                    tryAgainCallBack = { viewModel.getUserInfo() }
                ) {
                    UserDetailView(user = uiState.user) {
                        onClickNavigation.invoke(it)
                    }
                }
            }
        }
    )
}
