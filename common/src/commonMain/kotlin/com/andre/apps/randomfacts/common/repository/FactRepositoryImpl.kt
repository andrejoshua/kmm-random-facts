package com.andre.apps.randomfacts.common.repository

import com.andre.apps.randomfacts.common.api.FactsApi
import com.andre.apps.randomfacts.common.model.Fact
import com.andre.apps.randomfacts.common.model.Result

class FactRepositoryImpl(private val api: FactsApi) : FactRepository,
    ApiProcess by ApiProcessImpl() {

    override suspend fun getRandom(): Result<Fact> {
        return getResult({
            api.getRandomFact()
        }, {
            Fact(it.text)
        })
    }
}