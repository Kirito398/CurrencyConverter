package ru.biozzlab.currencyconverter.interfaces

import ru.biozzlab.domain.enums.CurrencyEnum

interface MainContract {
    interface View {
        fun init(currencyNameList: Array<CurrencyEnum>)
        fun setListeners()
        fun setFromCurrencyValue(value: Double)
        fun setToCurrencyValue(value: Double)
    }

    interface Presenter {
        fun setView(view: View)
        fun init()
        fun onFromCurrencyValueChanged(value: Double)
        fun onToCurrencyValueChanged(value: Double)
        fun onFromCurrencyTypeChanged(type: CurrencyEnum)
        fun onToCurrencyTypeChanged(type: CurrencyEnum)
    }
}