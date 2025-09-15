package com.ijk.android_mvvm_example.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseUseCase {

    suspend fun <T> onIo(block: suspend () -> T): T {
        return withContext(Dispatchers.IO) { block() }
    }
}