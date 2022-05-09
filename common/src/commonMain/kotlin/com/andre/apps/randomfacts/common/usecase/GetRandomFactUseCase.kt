package com.andre.apps.randomfacts.common.usecase

import com.andre.apps.randomfacts.common.model.Fact
import com.andre.apps.randomfacts.common.model.Result
import com.andre.apps.randomfacts.common.repository.FactRepository
import com.andre.apps.randomfacts.common.util.DispatcherProvider

class GetRandomFactUseCase(
    private val repository: FactRepository,
    dispatcherProvider: DispatcherProvider
) : UseCase(dispatcherProvider) {

    fun execute() = retrieveNetwork {
        repository.getRandom()
    }

    fun executeAndWatch(block: (Result<Fact>) -> Unit) = execute()
        .asCommonFlow()
        .watch(block)
}