package ru.biozzlab.currencyconverter

import android.app.Application
import ru.biozzlab.currencyconverter.dagger.components.AppComponent
import ru.biozzlab.currencyconverter.dagger.components.DaggerAppComponent

class App : Application() {
    companion object {
        private lateinit var component: AppComponent

        fun getComponent() = component
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
    }
}