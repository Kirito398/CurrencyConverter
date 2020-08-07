package ru.biozzlab.currencyconverter.ui.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import ru.biozzlab.currencyconverter.interfaces.listeners.OnCurrencyValueChangeListener
import ru.biozzlab.currencyconverter.ui.CurrencyItem
import ru.biozzlab.domain.enums.CurrencyEnum

class SwipeCurrencyFragmentAdapter(private val currencyList: Array<CurrencyEnum>, private val context: Context) :
    PagerAdapter() {
    private val itemList = mutableListOf<CurrencyItem>()
    private var onCurrencyValueChangeListener: OnCurrencyValueChangeListener? = null

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = CurrencyItem(currencyList[position], container, context)
        item.setOnCurrencyValueChangeListener(onCurrencyValueChangeListener)

        if (itemList.size -1 < position)
            itemList.add(item)
        else
            itemList[position] = item

        container.addView(item.getView())

        return item.getView()
    }

    fun setOnCurrencyValueChangeListener(listener: OnCurrencyValueChangeListener) {
        this.onCurrencyValueChangeListener = listener

        for (item in itemList)
            item.setOnCurrencyValueChangeListener(listener)
    }

    fun getItem(position: Int) = itemList[position]

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }

    override fun getCount(): Int = currencyList.size
}