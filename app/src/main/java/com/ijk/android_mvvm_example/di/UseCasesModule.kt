package com.ijk.android_mvvm_example.di

import com.ijk.android_mvvm_example.usecases.SearchMoviesUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory {
        SearchMoviesUseCase(api = get())
    }
}