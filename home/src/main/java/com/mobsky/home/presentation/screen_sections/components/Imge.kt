package com.mobsky.home.presentation.screen_sections.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun GitListImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    GitListSurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {
//        AsyncImage(
//            model = ImageRequest.Builder(LocalContext.current)
//                .data(imageUrl)
//                .crossfade(true)
//                .build(),
//            contentDescription = contentDescription,
//            placeholder = painterResource(R.drawable.ic_launcher_background),
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.Crop,
//        )
    }
}