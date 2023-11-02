package com.ijk.android_mvvm_example.di

import com.ijk.android_mvvm_example.network.MoviesApiConfig
import org.koin.dsl.module

val networkModule = module {
    single {
        MoviesApiConfig().createNetworkService()
    }
}