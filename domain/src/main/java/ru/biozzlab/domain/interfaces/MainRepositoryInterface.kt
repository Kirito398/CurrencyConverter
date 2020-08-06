package ru.biozzlab.domain.interfaces

import ru.biozzlab.domain.enums.CurrencyEnum
import ru.biozzlab.domain.models.CurrencyModel

interface MainRepositoryInterface {
    fun startMonitoringRates()
    fun getLatestRates(): Map<CurrencyEnum, CurrencyModel>
}