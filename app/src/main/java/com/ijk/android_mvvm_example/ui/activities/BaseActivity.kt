package com.ijk.android_mvvm_example.ui.activities

import androidx.activity.ComponentActivity
import com.ijk.android_mvvm_example.App

abstract class BaseActivity: ComponentActivity() {

    override fun onResume() {
        super.onResume()
        App.setCurrentActivity(this)
    }
}