package ru.biozzlab.currencyconverter.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.currency_item.*
import ru.biozzlab.currencyconverter.R
import ru.biozzlab.currencyconverter.enums.CurrencyFragmentType
import ru.biozzlab.currencyconverter.viewmodels.CurrencyViewModel
import ru.biozzlab.domain.enums.CurrencyEnum

class CurrencyFragment(private var currency: CurrencyEnum = CurrencyEnum.EUR, private var type: CurrencyFragmentType = CurrencyFragmentType.FROM) : Fragment() {
    private lateinit var currencyViewModel: CurrencyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.currency_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setListeners()
    }

    private fun init() {
        tvCurrencyType.text = currency.type
        currencyViewModel = ViewModelProviders.of(activity!!).get(type.type, CurrencyViewModel::class.java)
        currencyViewModel.setCurrencyType(currency)
    }

    private fun setListeners() {
        etCurrencyValue?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                onCurrencyValueChanged(p0.toString())
            }
        })
    }

    private fun onCurrencyValueChanged(value: String) {
        currencyViewModel.setCurrencyValue(if (value.isEmpty()) 0.0 else value.toDouble())
    }

    private fun clearValue() {
        etCurrencyValue?.text?.clear()
    }

    fun setCurrencyValue(value: Double) {
        if (etCurrencyValue?.isFocused != false)
            return

        if (value == 0.0)
            clearValue()
        else
            etCurrencyValue?.setText(value.toString())
    }
}