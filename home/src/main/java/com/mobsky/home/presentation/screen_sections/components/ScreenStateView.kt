package com.mobsky.home.presentation.screen_sections.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobsky.home.presentation.util.ScreenState
import com.mobsky.home.presentation.util.TaskState

@Composable
fun ScreenStateView(
    screenState: ScreenState,
    tryAgainCallBack: (() -> Unit)? = null,
    content: (@Composable () -> Unit)? = null
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        val showShimmer = remember { mutableStateOf(true) }

        when (val state = screenState.taskStateScreen) {
            TaskState.Complete -> content?.invoke()
            is TaskState.Error -> ErrorScreen(state.exception, tryAgainCallBack)
            TaskState.InProgress -> LoadScreen(showShimmer.value)
            TaskState.NotStarted -> Unit
        }
    }
}

@Composable
private fun ErrorScreen(
    exception: Exception,
    tryAgainAction: (() -> Unit)? = null
) {

    ComposableDialog()

    Column {
        Icon(
            imageVector = Icons.Filled.Info,
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
                .size(56.dp),
            contentDescription = ""
        )
        Text(
            text = exception.message ?: "Erro desconnhecido!",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .padding(top = 16.dp)
                .align(CenterHorizontally)
        )

        Button(
            modifier = Modifier
                .padding(top = 16.dp)
                .align(CenterHorizontally),
            onClick = { tryAgainAction?.invoke() }) {
            Text(text = "Tentar novamente?")
        }
    }
}

@Composable
private fun LoadScreen(showShimmer: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                shimmerBrush(targetValue = 1300f, showShimmer = showShimmer)
            )
    )
}

@Preview(showBackground = true)
@Composable
fun ScreenStateViewPreview() {

    val screenState = ScreenState(TaskState.Error(java.lang.Exception()))

    ScreenStateView(screenState)
}