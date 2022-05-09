package com.andre.apps.randomfacts.common.repository

import com.andre.apps.randomfacts.common.model.Result

interface ApiProcess {

    suspend fun <T1, T2> getResult(
        call: suspend () -> T1,
        mapper: (T1) -> T2
    ): Result<T2>
}