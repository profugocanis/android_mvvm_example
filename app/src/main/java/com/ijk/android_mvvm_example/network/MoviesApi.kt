package com.ijk.android_mvvm_example.network

import com.ijk.android_mvvm_example.models.Movie
import com.ijk.android_mvvm_example.network.responses.MoviesSearchResponse
import com.ijk.android_mvvm_example.utils.BuildUtils
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("/")
    suspend fun searchMovies(
        @Query(value = "s") text: String?,
        @Query(value = "y") year: String,
        @Query(value = "page") page: String,
        @Query(value = "apikey") apikey: String = BuildUtils.moviesApiKey,
    ): Response<MoviesSearchResponse>

    @GET("/")
    suspend fun getMovie(
        @Query(value = "i") imdbID: String?,
        @Query(value = "plot") plot: String?,
    ): Response<Movie>
}