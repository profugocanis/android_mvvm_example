package com.ijk.android_mvvm_example

import android.app.Activity
import android.app.Application
import com.ijk.android_mvvm_example.di.networkModule
import com.ijk.android_mvvm_example.di.useCasesModule
import com.ijk.android_mvvm_example.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        lateinit var application: Application
            private set

        fun getCurrentActivity(): Activity? {
            return (application as App).currentActivity
        }

        fun setCurrentActivity(activity: Activity) {
            (application as App).currentActivity = activity
        }
    }

    private var currentActivity: Activity? = null

    override fun onCreate() {
        super.onCreate()
        application = this
        initKoinDI()
    }

    private fun initKoinDI() {
        val modules = listOf(
            networkModule,
            useCasesModule,
            viewModelsModule
        )
        startKoin {
            androidContext(this@App)
            modules(modules)
        }
    }
}