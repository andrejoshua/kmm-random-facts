package com.andre.apps.randomfacts.android

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModules = module {
    viewModel { MainViewModel(get()) }
}