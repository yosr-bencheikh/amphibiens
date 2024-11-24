package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApi

class AmphibiansRepository {
    suspend fun fetchAmphibians(): List<Amphibian> {
        return AmphibianApi.retrofitService.getAmphibians()
    }
}
