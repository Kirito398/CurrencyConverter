package ru.biozzlab.currencyconverter.dagger.modules

import dagger.Module
import dagger.Provides
import ru.biozzlab.currencyconverter.interfaces.CurrencyContract
import ru.biozzlab.currencyconverter.interfaces.MainContract
import ru.biozzlab.currencyconverter.presenters.CurrencyPresenter
import ru.biozzlab.currencyconverter.presenters.MainPresenter

@Module
class PresentationModule {
    @Provides
    fun provideMainPresenter(): MainContract.Presenter {
        return MainPresenter()
    }

    @Provides
    fun provideCurrencyPresenter(): CurrencyContract.Presenter {
        return CurrencyPresenter()
    }
}