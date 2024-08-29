package com.ijk.android_mvvm_example.core.viewmodel

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.ijk.android_mvvm_example.core.ui.BaseState

@Suppress("UNCHECKED_CAST")
abstract class BaseStateViewModel(application: Application) : BaseViewModel(application) {

    protected open var uiState: BaseState? = null

    @Composable
    fun <T : BaseState> rememberState(create: (Context) -> T): T {
        if (uiState == null) {
            uiState = create(LocalContext.current)
            uiState?.InitComposable()
            onInitState()
        }
        return uiState as T
    }

    protected open fun onInitState() = Unit
    protected abstract fun getState(): Any
}