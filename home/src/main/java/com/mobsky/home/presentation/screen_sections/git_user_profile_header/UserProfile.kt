package com.mobsky.home.presentation.screen_sections.git_user_profile_header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobsky.home.data.repository.User
import com.mobsky.home.presentation.screen_sections.components.GitListImage

@Composable
fun UserDetailView(
    user: User, navigate: (user: User) -> Unit
) {

    Column(Modifier.fillMaxSize()) {
        Title(user)
        TextButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 36.dp),
            onClick = { navigate(user) }
        ) {
            Text(text = "Repositorios")
        }
    }
}

@Composable
private fun Title(user: User) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .background(color = MaterialTheme.colorScheme.background)
    ) {

        GitListImage(
            imageUrl = user.avatarUrl,
            imageSize = 180.dp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            contentDescription = null
        )

        Text(
            text = user.name,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp)
        )
        Text(
            text = user.url,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp)
        )
    }
}

@Preview("default", showBackground = true)
@Composable
private fun UserDetailPreview() {
    UserDetailView(User(
        name = "Bruno",
        avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
        url = "https://api.github.com/users/lukas"

    ), navigate = { })
}
