package com.ijk.android_mvvm_example.core.ui

import android.content.Context
import android.widget.Toast

abstract class BaseState(val context: Context) {

    fun showError(error: Throwable?) {
        error ?: return
        val message = error.localizedMessage ?: return
        if (message.isEmpty()) return
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}