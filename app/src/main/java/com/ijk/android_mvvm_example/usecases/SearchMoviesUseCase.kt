package com.ijk.android_mvvm_example.usecases

import com.ijk.android_mvvm_example.core.network.Source
import com.ijk.android_mvvm_example.network.MoviesApi
import com.ijk.android_mvvm_example.network.responses.MoviesSearchResponse

class SearchMoviesUseCase(
    private val api: MoviesApi
) : BaseUseCase() {

    suspend operator fun invoke(searchText: String, page: Int): Source<MoviesSearchResponse> {
        return remoteDataSource.executeNetworkRequest {
            api.searchMovies(text = searchText, year = "", page = page.toString())
        }
    }
}