package ru.biozzlab.currencyconverter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.biozzlab.currencyconverter.App
import ru.biozzlab.currencyconverter.R
import ru.biozzlab.currencyconverter.interfaces.MainContract
import ru.biozzlab.currencyconverter.interfaces.adapters.OnPageChangeListenerAdapter
import ru.biozzlab.currencyconverter.interfaces.listeners.OnCurrencyValueChangeListener
import ru.biozzlab.currencyconverter.ui.adapters.SwipeCurrencyFragmentAdapter
import ru.biozzlab.domain.enums.CurrencyEnum
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainContract.Presenter

    private lateinit var currencyFromAdapter: SwipeCurrencyFragmentAdapter
    private lateinit var currencyToAdapter: SwipeCurrencyFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.getComponent().injectMainActivity(this)

        presenter.setView(this)
        presenter.init()
    }

    override fun init(currencyNameList: Array<CurrencyEnum>) {
        currencyFromAdapter = SwipeCurrencyFragmentAdapter(currencyNameList, applicationContext)
        currencyToAdapter = SwipeCurrencyFragmentAdapter(currencyNameList, applicationContext)

        vpCurrencyFrom.adapter = currencyFromAdapter
        vpCurrencyTo.adapter = currencyToAdapter
    }

    override fun setListeners() {
        currencyToAdapter.setOnCurrencyValueChangeListener(object : OnCurrencyValueChangeListener {
            override fun onCurrencyValueChangeListener(value: String) {
                presenter.onToCurrencyValueChanged(value)
            }
        })

        currencyFromAdapter.setOnCurrencyValueChangeListener(object : OnCurrencyValueChangeListener {
            override fun onCurrencyValueChangeListener(value: String) {
                presenter.onFromCurrencyValueChanged(value)
            }
        })

        vpCurrencyFrom.addOnPageChangeListener(object : OnPageChangeListenerAdapter {
            override fun onPageSelected(position: Int) {
                presenter.onFromCurrencyTypeChanged(currencyFromAdapter.getItem(position).getType())
            }
        })

        vpCurrencyTo.addOnPageChangeListener(object : OnPageChangeListenerAdapter {
            override fun onPageSelected(position: Int) {
                presenter.onToCurrencyTypeChanged(currencyToAdapter.getItem(position).getType())
            }
        })
    }

    override fun setFromCurrencyValue(value: String) {
        currencyFromAdapter.getItem(vpCurrencyFrom.currentItem).setCurrencyValue(value)
    }

    override fun setToCurrencyValue(value: String) {
        currencyToAdapter.getItem(vpCurrencyTo.currentItem).setCurrencyValue(value)
    }
}