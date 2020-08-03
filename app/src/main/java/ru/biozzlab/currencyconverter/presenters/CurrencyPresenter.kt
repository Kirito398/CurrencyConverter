package ru.biozzlab.currencyconverter.presenters

import ru.biozzlab.currencyconverter.interfaces.CurrencyContract

class CurrencyPresenter : CurrencyContract.Presenter {
    private lateinit var view: CurrencyContract.View

    override fun setView(view: CurrencyContract.View) {
        this.view = view
    }

    override fun init() {
        view.init()
        view.setListeners()
    }
}