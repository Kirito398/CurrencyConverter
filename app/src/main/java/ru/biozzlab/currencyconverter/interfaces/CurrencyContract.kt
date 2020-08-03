package ru.biozzlab.currencyconverter.interfaces

interface CurrencyContract {
    interface View {
        fun init()
        fun setListeners()
    }

    interface Presenter {
        fun setView(view: View)
        fun init()
    }
}