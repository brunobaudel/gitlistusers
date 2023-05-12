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
import com.mobsky.home.presentation.screen_sections.git_user_profile_header.UserDetailView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserSearchScreen(
    viewModel: UserSearchViewModel,
    onClickNavigation: (gitUser: GitUser) -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()
    val userNameRemember = remember { mutableStateOf("") }
    val userName = userNameRemember.value

    Scaffold(
        topBar = {
            SearchableTopBar(
                currentSearchText = "Buscar usuario",
                onSearchDispatched = { searchText ->
                    viewModel.getUserInfo(searchText)
                },
                onSearchTextChanged = { searchText ->
                    userNameRemember.value = searchText
                },
            )
        },
        content = { innerPadding ->
            Column(
                modifier = androidx.compose.ui.Modifier.padding(innerPadding)
            ) {
                ScreenStateView(uiState,
                    tryAgainCallBack = { viewModel.getUserInfo(userName) }
                ) {
                    UserDetailView(user = uiState.user) {
                        onClickNavigation.invoke(it)
                    }
                }
            }
        }
    )
}
