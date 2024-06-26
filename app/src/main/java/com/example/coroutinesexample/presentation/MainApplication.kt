package com.example.coroutinesexample.presentation

import android.app.Application
import com.example.coroutinesexample.di.dataModule
import com.example.coroutinesexample.di.networkModule
import com.example.coroutinesexample.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(presentationModule, dataModule, networkModule)
        }
    }
}