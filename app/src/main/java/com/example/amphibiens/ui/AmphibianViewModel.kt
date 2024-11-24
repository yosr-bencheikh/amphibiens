package com.example.amphibians.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.data.AmphibiansRepository
import com.example.amphibians.model.Amphibian
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AmphibianViewModel(
    private val repository: AmphibiansRepository
) : ViewModel() {
    private val _amphibians = MutableStateFlow<List<Amphibian>>(emptyList())
    val amphibians: StateFlow<List<Amphibian>> get() = _amphibians

    init {
        fetchAmphibians()
    }

    private fun fetchAmphibians() {
        viewModelScope.launch {
            try {
                _amphibians.value = repository.fetchAmphibians()
            } catch (e: Exception) {
                // Gérer les erreurs
            }
        }
    }
}
