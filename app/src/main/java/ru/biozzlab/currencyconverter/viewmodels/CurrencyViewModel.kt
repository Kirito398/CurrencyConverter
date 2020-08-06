package ru.biozzlab.currencyconverter.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.biozzlab.domain.enums.CurrencyEnum

class CurrencyViewModel : ViewModel() {
    private val currencyValue = MutableLiveData<Double>()
    private val currencyType = MutableLiveData<CurrencyEnum>()

    fun setCurrencyValue(value: Double) {
        currencyValue.value = value
    }

    fun getCurrencyValue(): MutableLiveData<Double> {
        return currencyValue
    }

    fun setCurrencyType(type: CurrencyEnum) {
        currencyType.value = type
    }

    fun getCurrencyType(): MutableLiveData<CurrencyEnum> {
        return currencyType
    }
}