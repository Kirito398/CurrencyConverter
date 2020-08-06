package ru.biozzlab.domain.interfaces

import ru.biozzlab.domain.enums.CurrencyEnum

interface MainInteractorInterface {
    fun convertCurrency(from: CurrencyEnum, to: CurrencyEnum, value: Double): Double?
}