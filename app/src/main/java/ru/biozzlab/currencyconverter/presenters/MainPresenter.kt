package ru.biozzlab.currencyconverter.presenters

import ru.biozzlab.currencyconverter.interfaces.MainContract

class MainPresenter : MainContract.Presenter {
    private lateinit var view: MainContract.View

    override fun setView(view: MainContract.View) {
        this.view = view
    }

    override fun init() {
        val currencyNameList = listOf("EUR", "RUB")

        view.init(currencyNameList)
        view.setListeners()
    }
}