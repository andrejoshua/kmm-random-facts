package com.andre.apps.randomfacts.android

import android.app.Application
import android.content.Context
import com.andre.apps.randomfacts.common.initKoin
import org.koin.dsl.module

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            module {
                single<Context> { this@MainApp }
            },
            vmModules
        )
    }
}