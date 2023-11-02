package com.ijk.android_mvvm_example.network.responses

import com.google.gson.annotations.SerializedName
import com.ijk.android_mvvm_example.models.Movie

data class MoviesSearchResponse(
    @SerializedName("Search") val list: List<Movie> = emptyList(),
    @SerializedName("totalResults") val totalResults: String? = null,
    @SerializedName("Response") val response: String? = null,
    @SerializedName("Error") val error: String? = null,
)