package com.ijk.android_mvvm_example.core.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope

abstract class BaseState {

    lateinit var context: Context
        private set
    lateinit var scope: CoroutineScope
        private set

    @Composable
    open fun InitComposable() {
        scope = rememberCoroutineScope()
        context = LocalContext.current
    }

    fun showError(error: Throwable?) {
        error ?: return
        val message = error.localizedMessage ?: return
        if (message.isEmpty()) return
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}