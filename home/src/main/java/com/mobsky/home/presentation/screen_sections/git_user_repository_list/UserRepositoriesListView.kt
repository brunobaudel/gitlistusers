package com.mobsky.home.presentation.screen_sections.git_user_repository_list

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobsky.home.R
import com.mobsky.home.data.repository.UserRepositories
import com.mobsky.home.domain.model.GitRepository

@Composable
fun UserRepositoriesListView(userRepositories: UserRepositories) {

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
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

    Box(modifier = Modifier.padding(4.dp)) {
        Card(
            elevation = 4.dp,
            backgroundColor = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 4.dp, start = 8.dp, end = 8.dp)
                        .fillMaxWidth(),
                    text = gitUserRepository.name,
                    style = MaterialTheme.typography.headlineMedium,
                )
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                        .fillMaxWidth(),
                    text = gitUserRepository.description,
                    style = MaterialTheme.typography.bodyLarge
                )

                Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
                    IconText("Forks:${gitUserRepository.getForkCountFormat()}", R.drawable.fork_git)
                    Spacer(modifier = Modifier.padding(8.dp))
                    IconText("Star:${gitUserRepository.getStarCountFormat()}", R.drawable.star_git)
                }
            }
        }
    }
}

@Composable
fun IconText(iconText: String, @DrawableRes drawableResId: Int) {
    Row {
        Icon(
            imageVector = ImageVector.vectorResource(drawableResId),
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