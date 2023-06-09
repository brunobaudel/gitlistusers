package com.mobsky.home.presentation.screen_sections.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GitListImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    imageSize: Dp =  90.dp,
    contentDescription: String?
) {
    Box(
        modifier = Modifier.padding(4.dp).then(modifier)
    ) {
        GlideImage(
            model = imageUrl,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(imageSize)
                .padding(5.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}