package com.example.amphibians.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.amphibians.data.AmphibiansRepository

class AmphibianViewModelFactory(
    private val repository: AmphibiansRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AmphibianViewModel::class.java)) {
            return AmphibianViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
