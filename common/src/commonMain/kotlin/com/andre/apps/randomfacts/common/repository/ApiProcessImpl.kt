package com.andre.apps.randomfacts.common.repository

import com.andre.apps.randomfacts.common.model.Result

class ApiProcessImpl : ApiProcess {

    override suspend fun <T1, T2> getResult(
        call: suspend () -> T1,
        mapper: (T1) -> T2
    ): Result<T2> {
        return try {
            val response = call.invoke()
            Result.success(mapper(response))
        } catch (e: Exception) {
            error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        return Result.error("Call failed: $message")
    }
}