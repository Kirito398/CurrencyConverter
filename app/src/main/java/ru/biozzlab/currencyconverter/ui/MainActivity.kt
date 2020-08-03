package ru.biozzlab.currencyconverter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.biozzlab.currencyconverter.App
import ru.biozzlab.currencyconverter.R
import ru.biozzlab.currencyconverter.interfaces.MainContract
import ru.biozzlab.currencyconverter.ui.adapters.SwipeCurrencyFragmentAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.getComponent().injectMainActivity(this)

        presenter.setView(this)
        presenter.init()
    }

    override fun init(currencyNameList: List<String>) {
        val currencyFromAdapter = SwipeCurrencyFragmentAdapter(currencyNameList, supportFragmentManager)
        val currencyToAdapter = SwipeCurrencyFragmentAdapter(currencyNameList, supportFragmentManager)

        vpCurrencyFrom.adapter = currencyFromAdapter
        vpCurrencyTo.adapter = currencyToAdapter
    }

    override fun setListeners() {
        //TODO("Not yet implemented")
    }
}