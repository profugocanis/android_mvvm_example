package com.ijk.android_mvvm_example.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.ijk.android_mvvm_example.core.ui.BaseScreen
import com.ijk.android_mvvm_example.ui.screens.searchmovies.SearchMoviesActivity

object MainScreen : BaseScreen() {

    @Composable
    fun Screen() {
        val context = LocalContext.current
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { SearchMoviesActivity.open(context) }) {
                Text(text = "Search Movies")
            }
        }
    }
}