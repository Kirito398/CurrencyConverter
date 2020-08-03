package ru.biozzlab.currencyconverter.interfaces

interface MainContract {
    interface View {
        fun init(currencyNameList: List<String>)
        fun setListeners()
    }

    interface Presenter {
        fun setView(view: View)
        fun init()
    }
}