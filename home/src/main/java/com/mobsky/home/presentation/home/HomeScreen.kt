package com.mobsky.home.presentation.home

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mobsky.home.domain.model.GitUser
import com.mobsky.home.presentation.screen_sections.git_user_list.UserListView
import com.mobsky.home.presentation.util.TaskState
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, onClickNavigation: (gitUser: GitUser) -> Unit) {
    Scaffold(
        content = {
            HomeView(viewModel, onClickNavigation)
        }
    )
}

@Composable
fun HomeView(viewModel: HomeScreenViewModel, onClickNavigation: (gitUser: GitUser) -> Unit) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.taskState == TaskState.NotStarted) {
        viewModel.getUsers()
    }

    when (uiState.taskState) {
        TaskState.Complete -> UserListView(
            users = uiState.users,
            onItemClick = { onClickNavigation(it) }
        )

        is TaskState.Error -> ComposableExcluirDadosNavegacao()
        TaskState.InProgress -> Unit
        TaskState.NotStarted -> Unit
    }
}

@Composable
fun ComposableExcluirDadosNavegacao(
    onConfirmButton: () -> Unit = {},
    onDismissButton: () -> Unit = {},
    setShowDialog: (Boolean) -> Unit = {}
) {
    AlertDialog(
        onDismissRequest = { setShowDialog(false) },
        confirmButton = {
            TextButton(onClick = {
                onConfirmButton()
                setShowDialog(false)
            }) {
                Text("Apagar")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismissButton()
                setShowDialog(false)
            }) {
                Text("Cancelar")
            }
        },
        icon = { Icon(Icons.Filled.Info, null) },
        title = { Text(text = "Apagar dados de navegação?", fontSize = 20.sp) },
        text = null, //{ Text(text = "Isso vai fazer com que seu histórico de navegação seja completamente apagado.") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenHomePreview() {

}