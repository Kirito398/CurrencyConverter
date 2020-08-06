package ru.biozzlab.data.repositories

import kotlinx.coroutines.*
import ru.biozzlab.data.web.API
import ru.biozzlab.domain.interfaces.MainRepositoryInterface
import ru.biozzlab.data.models.RatesModel
import ru.biozzlab.domain.enums.CurrencyEnum
import ru.biozzlab.domain.models.CurrencyModel

class MainRepository(private val webClient: API): MainRepositoryInterface {
    private val scope = CoroutineScope(SupervisorJob())
    private lateinit var currentRatesList: Map<CurrencyEnum, CurrencyModel>

    override fun startMonitoringRates() {
        scope.launch(Dispatchers.IO) {
            do {
                val res = async(Dispatchers.IO) {
                    webClient.getLatestRates()
                }

                currentRatesList = convertRatesModelToCurrencyList(res.await())

                delay(30000)
            } while (true)
        }
    }

    override fun getLatestRates(): Map<CurrencyEnum, CurrencyModel> {
        return currentRatesList
    }

    private fun convertRatesModelToCurrencyList(rates: RatesModel): Map<CurrencyEnum, CurrencyModel> {
        val list = mutableMapOf<CurrencyEnum, CurrencyModel>()

        list[CurrencyEnum.EUR] = CurrencyModel(1.0)

        for (currency in CurrencyEnum.values()) {
            rates.rates[currency.type]?.let {
                list.put(currency, CurrencyModel(it))
            }
        }

        return list
    }
}