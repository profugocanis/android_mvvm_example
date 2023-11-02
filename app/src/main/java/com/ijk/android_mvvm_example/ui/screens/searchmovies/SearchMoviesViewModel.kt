package com.ijk.android_mvvm_example.ui.screens.searchmovies

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.ijk.android_mvvm_example.core.logget
import com.ijk.android_mvvm_example.core.ui.BaseState
import com.ijk.android_mvvm_example.core.viewmodel.BaseStateViewModel
import com.ijk.android_mvvm_example.core.viewmodel.BaseViewModel
import com.ijk.android_mvvm_example.usecases.SearchMoviesUseCase
import kotlinx.coroutines.launch

class SearchMoviesViewModel(
    application: Application,
    private val searchMoviesUseCase: SearchMoviesUseCase
) : BaseStateViewModel(application) {

    override val uiState = SearchMoviesState()

    private var page = 1

    fun search() {
        uiState.isLoading = true
        launchWithSafeNetwork {
            val source = searchMoviesUseCase("one", page)
            logget(source)
            uiState.isLoading = false
        }
    }
}