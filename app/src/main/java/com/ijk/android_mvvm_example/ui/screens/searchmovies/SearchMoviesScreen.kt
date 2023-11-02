package com.ijk.android_mvvm_example.ui.screens.searchmovies

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.ijk.android_mvvm_example.core.ui.BaseScreen
import org.koin.androidx.compose.koinViewModel

object SearchMoviesScreen: BaseScreen() {

    @Composable
    fun Screen(viewModel: SearchMoviesViewModel = koinViewModel()) {
        val state: SearchMoviesState = viewModel.getState()
        LaunchedEffect(Unit) {
            viewModel.search()
        }
        if (state.isLoading) {
            Text(text = "Loading")
        } else {
            Text(text = "Search Movies Screen")
        }
    }
}