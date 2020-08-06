package ru.biozzlab.currencyconverter.dagger.modules

import dagger.Module
import dagger.Provides
import ru.biozzlab.currencyconverter.interfaces.MainContract
import ru.biozzlab.currencyconverter.presenters.MainPresenter
import ru.biozzlab.domain.interfaces.MainInteractorInterface
import javax.inject.Singleton

@Module
class PresentationModule {
    @Provides
    @Singleton
    fun provideMainPresenter(interactor: MainInteractorInterface): MainContract.Presenter {
        return MainPresenter(interactor)
    }
}