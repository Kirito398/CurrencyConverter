package ru.biozzlab.currencyconverter.dagger.modules

import dagger.Module
import dagger.Provides
import ru.biozzlab.domain.interactors.MainInteractor
import ru.biozzlab.domain.interfaces.MainInteractorInterface
import ru.biozzlab.domain.interfaces.MainRepositoryInterface
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideMainInteractor(repository: MainRepositoryInterface): MainInteractorInterface {
        return MainInteractor(repository)
    }
}