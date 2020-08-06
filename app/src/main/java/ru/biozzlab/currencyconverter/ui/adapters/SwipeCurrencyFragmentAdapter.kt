package ru.biozzlab.currencyconverter.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.biozzlab.currencyconverter.enums.CurrencyFragmentType
import ru.biozzlab.currencyconverter.ui.fragments.CurrencyFragment
import ru.biozzlab.domain.enums.CurrencyEnum

class SwipeCurrencyFragmentAdapter(currencyList: Array<CurrencyEnum>, fragmentManager: FragmentManager, type: CurrencyFragmentType) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val fragmentList = mutableListOf<Fragment>()

    init {
        for (currency in currencyList)
            fragmentList.add(CurrencyFragment(currency, type))
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount() = fragmentList.size
}