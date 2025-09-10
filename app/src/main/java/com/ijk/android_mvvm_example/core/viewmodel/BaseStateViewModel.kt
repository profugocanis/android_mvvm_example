package com.ijk.android_mvvm_example.core.viewmodel

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.ijk.android_mvvm_example.core.ui.BaseState

@Suppress("UNCHECKED_CAST")
abstract class BaseStateViewModel(application: Application) : BaseViewModel(application) {

    protected open lateinit var uiState: BaseState
    open val state: BaseState get() = uiState

    @Composable
    fun <T : BaseState> rememberState(create: @DisallowComposableCalls (Context) -> T): T {
        if (::uiState.isInitialized) {
            return uiState as T
        }
        val context = LocalContext.current
        val state = create(context)
        uiState = state
        onInitState()
        return state
    }

    protected open fun onInitState() = Unit
}