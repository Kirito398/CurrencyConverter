package ru.biozzlab.domain.interfaces

import ru.biozzlab.domain.models.RatesModel

interface MainRepositoryInterface {
    suspend fun getLatestRates(): RatesModel
}