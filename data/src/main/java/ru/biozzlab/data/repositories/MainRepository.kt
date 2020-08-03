package ru.biozzlab.data.repositories

import ru.biozzlab.data.web.API
import ru.biozzlab.domain.interfaces.MainRepositoryInterface

class MainRepository(private val webClient: API): MainRepositoryInterface {
    override suspend fun getLatestRates() = webClient.getLatestRates()
}