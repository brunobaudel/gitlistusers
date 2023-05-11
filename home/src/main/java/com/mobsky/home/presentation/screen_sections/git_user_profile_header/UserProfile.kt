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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobsky.home.data.repository.User
import com.mobsky.home.presentation.screen_sections.components.GitListImage


private val HzPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun UserDetailView(
    user: User, navigate: (user: User) -> Unit
) {

    Column(Modifier.fillMaxSize()) {
        Image(user.avatarUrl)
        Title(user)
        TextButton(
            modifier = HzPadding,
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
            .background(color = MaterialTheme.colorScheme.background)) {
        Text(
            text = user.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = HzPadding
        )
        Text(
            text = user.url,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 20.sp,
            modifier = HzPadding
        )
    }
}

@Composable
private fun Image(imageUrl: String) {
    GitListImage(imageUrl = imageUrl, contentDescription = null)
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
