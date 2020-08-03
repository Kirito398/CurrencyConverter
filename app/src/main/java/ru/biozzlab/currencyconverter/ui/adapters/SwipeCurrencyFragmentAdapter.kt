package ru.biozzlab.currencyconverter.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.biozzlab.currencyconverter.ui.fragments.CurrencyFragment

class SwipeCurrencyFragmentAdapter(private val currencyList: List<String>, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return CurrencyFragment(currencyList[position])
    }

    override fun getCount() = currencyList.size
}