package com.andre.apps.randomfacts.common

import com.andre.apps.randomfacts.common.usecase.GetRandomFactUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class UseCaseBridge : KoinComponent {
    private val _randomFact: GetRandomFactUseCase by inject()

    fun getRandomFact(): GetRandomFactUseCase = _randomFact
}