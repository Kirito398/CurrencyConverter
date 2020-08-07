package ru.biozzlab.currencyconverter.interfaces.adapters

import androidx.viewpager.widget.ViewPager

interface OnPageChangeListenerAdapter : ViewPager.OnPageChangeListener {
    override fun onPageScrollStateChanged(state: Int) = Unit
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = Unit
    override fun onPageSelected(position: Int) = Unit
}