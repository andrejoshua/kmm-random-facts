package com.andre.apps.randomfacts.common.repository

import com.andre.apps.randomfacts.common.model.Fact
import com.andre.apps.randomfacts.common.model.Result

interface FactRepository {

    suspend fun getRandom(): Result<Fact>
}