package ru.biozzlab.currencyconverter.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import ru.biozzlab.currencyconverter.R
import ru.biozzlab.currencyconverter.interfaces.adapters.TextWatcherAdapter
import ru.biozzlab.currencyconverter.interfaces.listeners.OnCurrencyValueChangeListener
import ru.biozzlab.domain.enums.CurrencyEnum

class CurrencyItem(private val type: CurrencyEnum, container: ViewGroup, context: Context) {
    private var etCurrencyValue: EditText
    private var tvCurrencyType: TextView
    private var view: View

    private var onCurrencyValueChangeListener: OnCurrencyValueChangeListener? = null

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = inflater.inflate(R.layout.currency_item, container, false)

        etCurrencyValue = view.findViewById(R.id.etCurrencyValue)
        tvCurrencyType = view.findViewById(R.id.tvCurrencyType)

        tvCurrencyType.text = type.type

        setListeners()
    }

    private fun setListeners() {
        etCurrencyValue.addTextChangedListener(object : TextWatcherAdapter {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                onCurrencyValueChangeListener?.onCurrencyValueChangeListener(p0.toString())
            }
        })
    }

    fun getView() = view

    fun getType() = type

    fun setCurrencyValue(value: String) {
        if (etCurrencyValue.isFocused)
            return

        if (value.isEmpty())
            etCurrencyValue.text.clear()
        else
            etCurrencyValue.setText(value)
    }

    fun setOnCurrencyValueChangeListener(listener: OnCurrencyValueChangeListener?) {
        onCurrencyValueChangeListener = listener
    }
}