package ru.biozzlab.currencyconverter.dagger.components

import dagger.Component
import ru.biozzlab.currencyconverter.dagger.modules.DataModule
import ru.biozzlab.currencyconverter.dagger.modules.DomainModule
import ru.biozzlab.currencyconverter.dagger.modules.PresentationModule
import ru.biozzlab.currencyconverter.ui.MainActivity
import ru.biozzlab.currencyconverter.ui.fragments.CurrencyFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [PresentationModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun injectMainActivity(activity: MainActivity)
    fun injectCurrencyFragment(fragment: CurrencyFragment)
}