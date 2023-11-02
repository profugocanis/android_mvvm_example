package com.ijk.android_mvvm_example.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ijk.android_mvvm_example.ui.screens.searchmovies.SearchMoviesScreen
import com.ijk.android_mvvm_example.ui.theme.Android_mvvm_exampleTheme

class SearchMoviesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_mvvm_exampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SearchMoviesScreen.Screen()
                }
            }
        }
    }

    companion object {

        fun open(context: Context) {
            val intent = Intent(context, SearchMoviesActivity::class.java)
            context.startActivity(intent)
        }
    }
}