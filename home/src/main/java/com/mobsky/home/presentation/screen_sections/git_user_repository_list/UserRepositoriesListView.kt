package com.mobsky.home.presentation.screen_sections.git_user_repository_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobsky.home.domain.model.GitRepository
import com.mobsky.home.presentation.user_repositories.UserRepositoryScreenState
import kotlinx.coroutines.flow.StateFlow

@Composable
fun UserRepositoriesListView(
    uiStateFlow: StateFlow<UserRepositoryScreenState>
) {

    val uiState by uiStateFlow.collectAsState()

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (uiState.userRepositories.isNotEmpty()) {
            LazyColumn {
                items(uiState.userRepositories) {
                    UserRepositoryListItem(it)
                }
            }
        }
    }
}

@Composable
fun UserRepositoryListItem(gitUserRepository: GitRepository) {
    Card(
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier
            .padding(start = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column (modifier = Modifier.padding(horizontal = 8.dp)){
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    text = gitUserRepository.name,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp),
                    text = gitUserRepository.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UsersListItemPreview() {
    UserRepositoryListItem(GitRepository("191", "Bruno", false))
}