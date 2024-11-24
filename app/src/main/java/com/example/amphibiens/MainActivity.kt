package com.example.amphibians.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.data.DefaultAppContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContainer = DefaultAppContainer()
        val viewModelFactory = AmphibianViewModelFactory(appContainer.amphibiansRepository)

        setContent {
            AmphibianListScreen(viewModel = viewModel(factory = viewModelFactory))
        }
    }
}
