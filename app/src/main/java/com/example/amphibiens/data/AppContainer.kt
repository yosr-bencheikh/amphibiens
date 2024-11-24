package com.example.amphibians.data

import com.example.amphibians.network.AmphibianApi

interface AppContainer {
    val amphibiansRepository: AmphibiansRepository
}

class DefaultAppContainer : AppContainer {
    override val amphibiansRepository: AmphibiansRepository
        get() = AmphibiansRepository()
}
