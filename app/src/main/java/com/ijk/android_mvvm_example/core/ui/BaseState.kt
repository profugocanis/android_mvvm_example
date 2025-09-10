package com.ijk.android_mvvm_example.core.ui

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope

abstract class BaseState(val context: Context) {
    lateinit var scope: CoroutineScope

    fun showError(error: Throwable?) {
        error ?: return
        val message = error.localizedMessage ?: return
        if (message.isEmpty()) return
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}