package ru.biozzlab.data.web

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    fun getClient(): API {
        return Retrofit.Builder()
            .baseUrl("https://api.exchangeratesapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }
}