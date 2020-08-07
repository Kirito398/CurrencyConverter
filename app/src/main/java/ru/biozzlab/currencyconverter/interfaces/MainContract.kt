package ru.biozzlab.currencyconverter.interfaces

import ru.biozzlab.domain.enums.CurrencyEnum

interface MainContract {
    interface View {
        fun init(currencyNameList: Array<CurrencyEnum>)
        fun setListeners()
        fun setFromCurrencyValue(value: String)
        fun setToCurrencyValue(value: String)
    }

    interface Presenter {
        fun setView(view: View)
        fun init()
        fun onFromCurrencyValueChanged(value: String)
        fun onToCurrencyValueChanged(value: String)
        fun onFromCurrencyTypeChanged(type: CurrencyEnum)
        fun onToCurrencyTypeChanged(type: CurrencyEnum)
    }
}