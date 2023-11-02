package com.ijk.android_mvvm_example.network

import android.util.MalformedJsonException
import com.google.gson.JsonElement
import com.ijk.android_mvvm_example.core.network.BaseRemoteDataSource
import com.ijk.android_mvvm_example.core.network.Source
import org.koin.core.component.KoinComponent
import java.io.IOException

class RemoteDataSource : BaseRemoteDataSource(), KoinComponent {

    override fun handleServerError(jsonError: JsonElement?, errorCode: Int): Source.Error {
        return when (errorCode) {
            401 -> {
                showLogin()
                Source.Error(Exception("Unauthorized"))
            }

            426 -> {
                cancelChildrenRequests()
                showNewVersionDialog()
                Source.Error(RuntimeException("Old version"))
            }

            in 500..599 -> {
                Source.Error(Exception("Opps"))
            }

            else -> {
                val errorMessage = jsonError?.asJsonObject?.get("error")?.asString
                if (errorMessage != null) {
                    return Source.Error(RuntimeException(errorMessage))
                }
                return Source.Error(RuntimeException("Data extract error, code: $errorCode"))
            }
        }
    }

    override fun handleException(e: Exception): Source.Error {
        return when (e) {
            is MalformedJsonException -> Source.Error(e)
            is IOException -> Source.Error(Exception("You might be offline!"))
            else -> Source.Error(e)
        }
    }

    private fun showLogin() {
        cancelChildrenRequests()
    }

    private fun showNewVersionDialog() {

    }
}