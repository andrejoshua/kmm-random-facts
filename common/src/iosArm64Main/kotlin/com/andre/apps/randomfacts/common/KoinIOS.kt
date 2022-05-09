package com.andre.apps.randomfacts.common

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*
import org.koin.core.KoinApplication
import org.koin.core.module.Module
import org.koin.dsl.module

fun initKoinIos(
    doOnStartup: () -> Unit,
): KoinApplication = initKoin(
    module {
        single { doOnStartup }
    },
    module {

    }
)

actual val platformModule: Module = module {
    single<HttpClientEngine> {
        Ios.create()
    }
}