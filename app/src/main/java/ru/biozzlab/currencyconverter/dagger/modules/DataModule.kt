package ru.biozzlab.currencyconverter.dagger.modules

import dagger.Module
import dagger.Provides
import ru.biozzlab.data.repositories.MainRepository
import ru.biozzlab.data.web.APIClient
import ru.biozzlab.domain.interfaces.MainRepositoryInterface

@Module
class DataModule {

    @Provides
    fun provideMainRepository(): MainRepositoryInterface {
        return MainRepository(APIClient.getClient())
    }
}