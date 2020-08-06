package ru.biozzlab.currencyconverter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import ru.biozzlab.currencyconverter.App
import ru.biozzlab.currencyconverter.R
import ru.biozzlab.currencyconverter.enums.CurrencyFragmentType
import ru.biozzlab.currencyconverter.interfaces.MainContract
import ru.biozzlab.currencyconverter.ui.adapters.SwipeCurrencyFragmentAdapter
import ru.biozzlab.currencyconverter.ui.fragments.CurrencyFragment
import ru.biozzlab.currencyconverter.viewmodels.CurrencyViewModel
import ru.biozzlab.domain.enums.CurrencyEnum
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainContract.Presenter

    private lateinit var currencyFromAdapter: SwipeCurrencyFragmentAdapter
    private lateinit var currencyToAdapter: SwipeCurrencyFragmentAdapter
    private lateinit var fromCurrencyViewModel: CurrencyViewModel
    private lateinit var toCurrencyViewModel: CurrencyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.getComponent().injectMainActivity(this)

        presenter.setView(this)
        presenter.init()
    }

    override fun init(currencyNameList: Array<CurrencyEnum>) {
        currencyFromAdapter = SwipeCurrencyFragmentAdapter(currencyNameList, supportFragmentManager, CurrencyFragmentType.FROM)
        currencyToAdapter = SwipeCurrencyFragmentAdapter(currencyNameList, supportFragmentManager, CurrencyFragmentType.TO)

        vpCurrencyFrom.adapter = currencyFromAdapter
        vpCurrencyTo.adapter = currencyToAdapter

        fromCurrencyViewModel = ViewModelProviders.of(this).get(CurrencyFragmentType.FROM.type, CurrencyViewModel::class.java)
        toCurrencyViewModel = ViewModelProviders.of(this).get(CurrencyFragmentType.TO.type, CurrencyViewModel::class.java)
    }

    override fun setListeners() {
        fromCurrencyViewModel
            .getCurrencyValue()
            .observe(this, Observer { presenter.onFromCurrencyValueChanged(it) })

        toCurrencyViewModel
            .getCurrencyValue()
            .observe(this, Observer { presenter.onToCurrencyValueChanged(it) })

        fromCurrencyViewModel
            .getCurrencyType()
            .observe(this, Observer { presenter.onFromCurrencyTypeChanged(it) })

        toCurrencyViewModel
            .getCurrencyType()
            .observe(this, Observer { presenter.onToCurrencyTypeChanged(it) })
    }

    override fun setFromCurrencyValue(value: Double) {
        (currencyFromAdapter.getItem(vpCurrencyFrom.currentItem) as CurrencyFragment).setCurrencyValue(value)
    }

    override fun setToCurrencyValue(value: Double) {
        (currencyToAdapter.getItem(vpCurrencyTo.currentItem) as CurrencyFragment).setCurrencyValue(value)
    }
}