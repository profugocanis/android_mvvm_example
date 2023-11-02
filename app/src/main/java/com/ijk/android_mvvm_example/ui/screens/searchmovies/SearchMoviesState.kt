package com.ijk.android_mvvm_example.ui.screens.searchmovies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.ijk.android_mvvm_example.core.ui.BaseState

class SearchMoviesState : BaseState() {

    var isLoading by mutableStateOf(false)
}