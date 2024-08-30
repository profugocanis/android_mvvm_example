package com.ijk.android_mvvm_example.ui.screens.searchmovies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ijk.android_mvvm_example.models.Movie

@Composable
fun MovieView(movie: Movie, itemWidthDp: Dp) {
    Box(
        modifier = Modifier
            .padding(start = 8.dp, top = 8.dp)
            .size(width = itemWidthDp, height = itemWidthDp + 56.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            model = movie.poster,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = movie.title ?: "", modifier = Modifier
                .background(Color.Black.copy(alpha = 0.6f))
                .padding(8.dp)
                .fillMaxWidth(),
            color = Color.White
        )
    }
}