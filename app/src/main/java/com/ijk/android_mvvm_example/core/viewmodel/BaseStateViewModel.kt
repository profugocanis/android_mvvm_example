package com.ijk.android_mvvm_example.core.viewmodel

import android.app.Application
import androidx.compose.runtime.Composable
import com.ijk.android_mvvm_example.core.ui.BaseState

@Suppress("UNCHECKED_CAST")
abstract class BaseStateViewModel(application: Application) : BaseViewModel(application) {

    protected abstract val uiState: BaseState

    @Composable
    fun <T : BaseState> getState(): T {
        uiState.InitComposable()
        return uiState as T
    }
}