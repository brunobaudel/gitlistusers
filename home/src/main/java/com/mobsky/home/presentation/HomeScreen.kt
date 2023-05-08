package com.mobsky.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.mobsky.home.R
import com.mobsky.home.domain.model.GitUser
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {
    Scaffold(
        content = {
            HomeView(viewModel)
        }
    )
}

@Composable
fun HomeView(viewModel: HomeScreenViewModel) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getUsers()
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (uiState.users.isNotEmpty()) {
            LazyColumn {
                items(uiState.users) {
                    UsersListItem(it)
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UsersListItem(gitUser: GitUser) {
    Card(
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier.padding(start = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Box {
//                Image(
//                    modifier = Modifier
//                        .padding(start = 8.dp, top = 20.dp, end = 8.dp, bottom = 20.dp)
//                        .align(Alignment.TopCenter),
//                    painter = painterResource(R.drawable.ic_launcher_background),
//                    contentDescription = null,
//                    colorFilter = ColorFilter.tint(color = colorResource(R.color.teal_200))
//                )

                GlideImage(
                    model = gitUser.avatarUrl,
                    contentDescription = "LoadImage",
                    modifier = Modifier.fillMaxSize())
            }
            Text(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp, end = 32.dp),
                text = gitUser.name,
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UsersListItemPreview(){
    UsersListItem(GitUser("191", "Bruno",""))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenHomePreview() {

//    val viewModel = koinViewModel<HomeScreenViewModel>()
//
//    viewModel.apply {
//        uiState.value.users = mutableListOf(
//            GitUser("bruno"),  GitUser("bruno2")
//        )
//    }
//
//    HomeScreen(viewModel)
}