package ru.biozzlab.currencyconverter.dagger.components

import dagger.Component
import ru.biozzlab.currencyconverter.dagger.modules.PresentationModule
import ru.biozzlab.currencyconverter.ui.MainActivity
import ru.biozzlab.currencyconverter.ui.fragments.CurrencyFragment

@Component(modules = [PresentationModule::class])
interface AppComponent {
    fun injectMainActivity(activity: MainActivity)
    fun injectCurrencyFragment(fragment: CurrencyFragment)
}