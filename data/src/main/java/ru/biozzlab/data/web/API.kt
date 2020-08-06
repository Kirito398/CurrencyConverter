package ru.biozzlab.data.web

import retrofit2.http.GET
import ru.biozzlab.data.models.RatesModel

interface API {
    @GET("latest")
    suspend fun getLatestRates(): RatesModel
}