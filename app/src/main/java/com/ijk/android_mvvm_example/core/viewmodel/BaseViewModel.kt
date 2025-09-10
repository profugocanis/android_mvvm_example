package com.ijk.android_mvvm_example.core.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ijk.android_mvvm_example.core.network.NetworkMonitor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.util.concurrent.Executors

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val networkMonitor = NetworkMonitor(application)

    protected suspend fun <X> noBlock(block: suspend () -> X): X {
        return withContext(Dispatchers.IO) {
            block.invoke()
        }
    }

    protected fun getString(resId: Int): String {
        return getApplication<Application>().getString(resId)
    }

    protected fun launchWithSafeNetwork(block: suspend CoroutineScope.() -> Unit) {
        networkMonitor.execute {
            if (!viewModelScope.isActive) return@execute
            viewModelScope.launch {
                block()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        networkMonitor.onClear()
    }

    fun launchWithError(onError: (Exception) -> Unit, launch: suspend () -> Unit) {
        viewModelScope.launch {
            withContext(threadDispatcher + job) {
                try {
                    launch()
                } catch (exception: Exception) {
                    withContext(Dispatchers.Main) {
                        onError(handleError(exception))
                    }
                }
            }
        }
    }

    private fun handleError(exception: Exception): Exception {
        if (exception is HttpException) {
            val errorCode = exception.code()
            return when (errorCode) {
                401 -> {
                    Exception("Unauthorized")
                }

                426 -> {
                    RuntimeException("Old version")
                }

                in 500..599 -> {
                    Exception("Oops")
                }

                else -> {
                    exception
                }
            }
        }
        return exception
    }

    companion object {
        private var job = Job()
        private val threadDispatcher = Executors.newFixedThreadPool(3).asCoroutineDispatcher()
    }
}