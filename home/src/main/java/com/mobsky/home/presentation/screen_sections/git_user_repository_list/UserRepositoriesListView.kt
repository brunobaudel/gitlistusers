package com.mobsky.home.presentation.screen_sections.git_user_repository_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobsky.home.data.repository.UserRepositories
import com.mobsky.home.domain.model.GitRepository

@Composable
fun UserRepositoriesListView(userRepositories: UserRepositories) {

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (userRepositories.isNotEmpty()) {
            LazyColumn {
                items(userRepositories) {
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
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
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

                Row {
                    IconText("Forks:${gitUserRepository.forksCount}")
                    Spacer(modifier = Modifier.padding(8.dp))
                    IconText("Star:${gitUserRepository.starCount}")
                }
            }
        }
    }
}

@Composable
fun IconText(iconText: String) {
    Row {
        Icon(
            imageVector = Icons.Rounded.Notifications,
            contentDescription = "Email Icon",
        )
        Text(text = iconText)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UsersListItemPreview() {
    UserRepositoryListItem(GitRepository("191", "Bruno", false))
}