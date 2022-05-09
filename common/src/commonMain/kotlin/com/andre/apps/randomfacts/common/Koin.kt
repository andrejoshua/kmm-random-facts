package com.andre.apps.randomfacts.common

import com.andre.apps.randomfacts.common.api.FactsApi
import com.andre.apps.randomfacts.common.api.FactsApiImpl
import com.andre.apps.randomfacts.common.ktor.getHttpClient
import com.andre.apps.randomfacts.common.repository.FactRepository
import com.andre.apps.randomfacts.common.repository.FactRepositoryImpl
import com.andre.apps.randomfacts.common.usecase.GetRandomFactUseCase
import com.andre.apps.randomfacts.common.util.DefaultDispatcherProvider
import com.andre.apps.randomfacts.common.util.DispatcherProvider
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import org.koin.dsl.module

fun initKoin(appModule: Module, viewModule: Module): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            platformModule,
            coreModule,
            viewModule
        )
    }

    // Dummy initialization logic, making use of appModule declarations for demonstration purposes.
    val koin = koinApplication.koin
    // doOnStartup is a lambda which is implemented in Swift on iOS side
    try {
        val doOnStartup = koin.get<() -> Unit>()
        doOnStartup.invoke()
    } catch (e: Exception) {
        // Do nothing
    }

    return koinApplication
}

private val coreModule = module {
    single {
        getHttpClient(
            get()
        )
    }
    single<DispatcherProvider> {
        DefaultDispatcherProvider()
    }
    single<FactsApi> {
        FactsApiImpl(
            get()
        )
    }
    single<FactRepository> {
        FactRepositoryImpl(get())
    }
    single {
        GetRandomFactUseCase(
            get(),
            get()
        )
    }
}

internal inline fun <reified T> Scope.getWith(vararg params: Any?): T {
    return get(parameters = { parametersOf(*params) })
}

expect val platformModule: Module