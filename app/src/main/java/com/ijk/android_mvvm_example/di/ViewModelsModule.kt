package com.ijk.android_mvvm_example.di

import com.ijk.android_mvvm_example.ui.screens.searchmovies.SearchMoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        SearchMoviesViewModel(
            application = get(),
            searchMoviesUseCase = get()
        )
    }
}