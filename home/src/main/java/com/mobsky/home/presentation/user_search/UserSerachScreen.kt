package com.mobsky.home.presentation.user_search

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mobsky.home.presentation.screen_sections.components.ScreenStateView
import com.mobsky.home.presentation.screen_sections.components.SearchableTopBar
import com.mobsky.home.presentation.screen_sections.git_user_profile_header.UserDetailView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserSearchScreen(
    viewModel: UserSearchViewModel
) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(

        topBar = {
            SearchableTopBar(
                currentSearchText = "Buscar usuario",
                onSearchTextChanged =  { },
                onSearchDeactivated = {  },
                onSearchDispatched =  { searchText ->  viewModel.getUserInfo(searchText) },
                onSearchIconClicked = {  }
            )
        },

        content = {
            ScreenStateView(uiState) {
                UserDetailView(user = uiState.user) {}
            }
        }
    )
}
