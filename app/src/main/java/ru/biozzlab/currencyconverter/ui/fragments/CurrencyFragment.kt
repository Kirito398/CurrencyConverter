package ru.biozzlab.currencyconverter.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.currency_fragment.*
import ru.biozzlab.currencyconverter.App
import ru.biozzlab.currencyconverter.R
import ru.biozzlab.currencyconverter.interfaces.CurrencyContract
import javax.inject.Inject

class CurrencyFragment(private val currencyName: String) : Fragment(), CurrencyContract.View {
    @Inject
    lateinit var presenter: CurrencyContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.currency_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.getComponent().injectCurrencyFragment(this)

        presenter.setView(this)
        presenter.init()
    }

    override fun init() {
        name.text = currencyName
    }

    override fun setListeners() {
        //TODO("Not yet implemented")
    }
}