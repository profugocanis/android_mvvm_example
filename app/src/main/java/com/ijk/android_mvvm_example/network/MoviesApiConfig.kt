package com.ijk.android_mvvm_example.network

import com.ijk.android_mvvm_example.core.network.BaseNetworkAPIConfig
import com.ijk.android_mvvm_example.utils.BuildUtils
import okhttp3.Interceptor

class MoviesApiConfig : BaseNetworkAPIConfig<MoviesApi>() {

    override fun isSslDisable() = false
    override fun getBaseUrl() = BuildUtils.moviesApiUrl
    override fun isLoggingEnable() = BuildUtils.isDebug
    override fun getServiceClass() = MoviesApi::class.java
    override fun applyInterceptor() = listOf<Interceptor>()
}