package com.ijk.android_mvvm_example.core.network

data class NetworkException(val code: Int, override val message: String? = null): Exception()