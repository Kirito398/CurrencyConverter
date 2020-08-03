package ru.biozzlab.domain.interactors

import kotlinx.coroutines.*
import ru.biozzlab.domain.interfaces.MainRepositoryInterface
import ru.biozzlab.domain.models.RatesModel

class MainInteractor(private val repository: MainRepositoryInterface) {
    private lateinit var currentRatesModel: RatesModel

    private val scope = CoroutineScope(SupervisorJob())

    init {
        startMonitoringRates()
    }

    fun startMonitoringRates() {
        scope.launch(Dispatchers.IO) {
            do {
                currentRatesModel = withContext(Dispatchers.IO) {
                    repository.getLatestRates()
                }

                delay(30000)
            } while (true)
        }
    }

    fun stopMonitoringRates() {
        scope.cancel()
    }
}