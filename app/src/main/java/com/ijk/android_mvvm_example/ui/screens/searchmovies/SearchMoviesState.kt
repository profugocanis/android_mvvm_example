package com.ijk.android_mvvm_example.ui.screens.searchmovies

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.ijk.android_mvvm_example.core.network.Source
import com.ijk.android_mvvm_example.core.ui.BaseState
import com.ijk.android_mvvm_example.models.Movie
import com.ijk.android_mvvm_example.network.responses.MoviesSearchResponse

class SearchMoviesState(context: Context) : BaseState(context) {

    var searchQuery by mutableStateOf("one")

    var isLoading by mutableStateOf(false)
    val movies = mutableStateListOf<Movie>()

    fun setMovies(response: MoviesSearchResponse) {
        this.movies.clear()
        this.movies.addAll(response.list)
    }
}