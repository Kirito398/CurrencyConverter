package ru.biozzlab.currencyconverter.presenters

import ru.biozzlab.currencyconverter.interfaces.MainContract
import ru.biozzlab.domain.enums.CurrencyEnum
import ru.biozzlab.domain.interfaces.MainInteractorInterface

class MainPresenter(private val interactor: MainInteractorInterface) : MainContract.Presenter {
    private lateinit var view: MainContract.View
    private lateinit var fromCurrencyType: CurrencyEnum
    private lateinit var toCurrencyType: CurrencyEnum

    override fun setView(view: MainContract.View) {
        this.view = view
    }

    override fun init() {
        val currencyNameList = CurrencyEnum.values()

        fromCurrencyType = currencyNameList.first()
        toCurrencyType = currencyNameList.first()

        view.init(currencyNameList)
        view.setListeners()
    }

    override fun onFromCurrencyValueChanged(value: String) {
        val dValue = if (value.isEmpty()) 0.0 else value.toDouble()
        val res = interactor.convertCurrency(fromCurrencyType, toCurrencyType, dValue) ?: return

        val sValue = if (res == 0.0) "" else "+$res"

        view.setToCurrencyValue(sValue)
    }

    override fun onToCurrencyValueChanged(value: String) {
        val dValue = if (value.isEmpty()) 0.0 else value.toDouble()
        val res = interactor.convertCurrency(toCurrencyType, fromCurrencyType, dValue) ?: return

        val sValue = if (res == 0.0) "" else "-$res"

        view.setFromCurrencyValue(sValue)
    }

    override fun onFromCurrencyTypeChanged(type: CurrencyEnum) {
        fromCurrencyType = type
    }

    override fun onToCurrencyTypeChanged(type: CurrencyEnum) {
        toCurrencyType = type
    }
}