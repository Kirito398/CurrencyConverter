package ru.biozzlab.domain.interactors

import ru.biozzlab.domain.enums.CurrencyEnum
import ru.biozzlab.domain.interfaces.MainInteractorInterface
import ru.biozzlab.domain.interfaces.MainRepositoryInterface

class MainInteractor(private val repository: MainRepositoryInterface) : MainInteractorInterface{
    init {
        repository.startMonitoringRates()
    }

    override fun convertCurrency(from: CurrencyEnum, to: CurrencyEnum, value: Double): Double? {
        val latestRates = repository.getLatestRates()
        val fromRate = latestRates[from]?.rate
        val toRate = latestRates[to]?.rate

        if (fromRate == null || toRate == null)
            return null

        return (value / fromRate) * toRate
    }
}