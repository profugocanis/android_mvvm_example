package com.ijk.android_mvvm_example.core.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteDataSource() {

    suspend fun <T> onIo(block: suspend () -> T): T {
        return withContext(Dispatchers.IO) { block() }
    }
}