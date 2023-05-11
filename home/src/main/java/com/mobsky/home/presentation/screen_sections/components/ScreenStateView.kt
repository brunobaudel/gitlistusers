package com.mobsky.home.presentation.screen_sections.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobsky.home.presentation.util.ScreenState
import com.mobsky.home.presentation.util.TaskState

@Composable
fun ScreenStateView(
    screenState: ScreenState,
    content: (@Composable () -> Unit)? = null
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        val showShimmer = remember { mutableStateOf(true) }

        when (val state = screenState.taskStateScreen) {
            TaskState.Complete -> content?.invoke()
            is TaskState.Error -> errorScreen(Exception("Test preview error!"))
            TaskState.NotStarted,
            TaskState.InProgress -> load(showShimmer.value)
        }
    }
}

@Composable
private fun errorScreen(exception: Exception) {

    Column(
        modifier = Modifier
    ) {
        Icon(
            imageVector = Icons.Filled.Info,
            modifier = Modifier
                .align(CenterHorizontally)
                .size(36.dp),
            contentDescription = ""
        )
        Text(
            text = exception.message.orEmpty(),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
private fun load(showShimmer: Boolean) {
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

    val screenState =
        // ScreenState(TaskState.Error(Exception("Test preview error!")))
        ScreenState(TaskState.InProgress)

    ScreenStateView(screenState)
}

@Composable
fun shimmerBrush(showShimmer: Boolean = true, targetValue: Float = 1000f): Brush {
    return if (showShimmer) {
        val shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.6f),
        )

        val transition = rememberInfiniteTransition()
        val translateAnimation = transition.animateFloat(
            initialValue = 0f,
            targetValue = targetValue,
            animationSpec = infiniteRepeatable(
                animation = tween(800), repeatMode = RepeatMode.Reverse
            )
        )
        Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnimation.value, y = translateAnimation.value)
        )
    } else {
        Brush.linearGradient(
            colors = listOf(Color.Transparent, Color.Transparent),
            start = Offset.Zero,
            end = Offset.Zero
        )
    }
}