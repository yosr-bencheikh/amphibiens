package com.example.amphibians.network

import com.example.amphibiens.network.AmphibianApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AmphibianApi {
    private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    val retrofitService: AmphibianApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AmphibianApiService::class.java)
    }
}