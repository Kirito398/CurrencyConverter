package ru.biozzlab.currencyconverter.dagger.modules

import dagger.Module
import dagger.Provides
import ru.biozzlab.currencyconverter.interfaces.CurrencyContract
import ru.biozzlab.currencyconverter.interfaces.MainContract
import ru.biozzlab.currencyconverter.presenters.CurrencyPresenter
import ru.biozzlab.currencyconverter.presenters.MainPresenter
import ru.biozzlab.domain.interactors.MainInteractor
import ru.biozzlab.domain.interfaces.MainInteractorInterface

@Module
class PresentationModule {
    @Provides
    fun provideMainPresenter(interactor: MainInteractorInterface): MainContract.Presenter {
        return MainPresenter(interactor)
    }

    @Provides
    fun provideCurrencyPresenter(): CurrencyContract.Presenter {
        return CurrencyPresenter()
    }
}