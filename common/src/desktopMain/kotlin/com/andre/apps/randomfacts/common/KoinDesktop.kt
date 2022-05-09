package com.andre.apps.randomfacts.common

import io.ktor.client.engine.*
import io.ktor.client.engine.apache.*
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<HttpClientEngine> {
        Apache.create()
    }
}