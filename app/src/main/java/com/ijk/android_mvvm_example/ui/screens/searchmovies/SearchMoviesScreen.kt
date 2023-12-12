package com.ijk.android_mvvm_example.ui.screens.searchmovies

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.ijk.android_mvvm_example.core.ui.BaseScreen
import com.ijk.android_mvvm_example.ui.dialogs.LoadingDialog
import org.koin.androidx.compose.koinViewModel

object SearchMoviesScreen : BaseScreen() {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Screen(viewModel: SearchMoviesViewModel = koinViewModel()) {
        val state: SearchMoviesState = viewModel.getState()

        val itemWidthDp = (LocalConfiguration.current.screenWidthDp / 2).dp - 4.dp

        LoadingDialog(isLoading = state.isLoading)

        Column {
            Row(modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = rememberVectorPainter(image = Icons.Default.ArrowBack),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        (state.context as? Activity)?.finish()
                    }
                )
                Spacer(modifier = Modifier)
            }
            TextField(
                state.searchQuery,
                onValueChange = { state.searchQuery = it },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = Color(0XFF070E14)
                ),
                placeholder = {
                    Text(text = "Search")
                },
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
            )
            if (!state.isLoading) {
                LazyVerticalGrid(
                    columns = GridCells.FixedSize(itemWidthDp),
                    modifier = Modifier.padding(end = 4.dp),
                    content = {
                        items(state.movies) {
                            MovieView(movie = it, itemWidthDp)
                        }
                        if (state.movies.isNotEmpty()) {
                            item {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator(
                                        color = Color.Blue,
                                        modifier = Modifier.padding(8.dp)
                                    )
                                }
                            }
                        }
                    })
            }
        }
    }
}