package com.ijk.android_mvvm_example.ui.screens.searchmovies

import android.app.Application
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.viewModelScope
import com.ijk.android_mvvm_example.core.logget
import com.ijk.android_mvvm_example.core.network.Source
import com.ijk.android_mvvm_example.core.ui.BaseState
import com.ijk.android_mvvm_example.core.viewmodel.BaseStateViewModel
import com.ijk.android_mvvm_example.usecases.SearchMoviesUseCase
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class SearchMoviesViewModel(
    application: Application,
    private val searchMoviesUseCase: SearchMoviesUseCase
) : BaseStateViewModel(application) {

    override fun getState() = uiState as SearchMoviesState

    private var page = 1

    override fun onInitState() {
        viewModelScope.launch {
            snapshotFlow { getState().searchQuery }
                .debounce(1_000)
                .collect {
                    val query = it.trim()
                    if (query.length >= 3) {
                        search(query)
                    }
                }
        }
    }

    private fun search(query: String) {
        getState().handleMovies(Source.Processing())
        launchWithSafeNetwork {
            val source = searchMoviesUseCase(query, page)
            getState().handleMovies(source)
        }
    }
}