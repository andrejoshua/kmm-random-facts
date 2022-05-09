package com.andre.apps.randomfacts.common.usecase

import com.andre.apps.randomfacts.common.model.Result
import com.andre.apps.randomfacts.common.util.DispatcherProvider
import io.ktor.utils.io.core.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

abstract class UseCase(
    private val dispatcherProvider: DispatcherProvider
) {

    protected fun <T> retrieveNetwork(
        networkCall: suspend () -> Result<T>
    ) = flow {
        emit(Result.loading())

        val call =
            withContext(dispatcherProvider.io()) { networkCall.invoke() }
        if (call.status == Result.Status.SUCCESS) {
            emit(call)
        } else {
            emit(Result.error(call.message!!, null))
        }
    }.flowOn(dispatcherProvider.default())

    protected fun <T> Flow<T>.asCommonFlow(): CommonFlow<T> = CommonFlow(this)
}

class CommonFlow<T>(private val origin: Flow<T>) : Flow<T> by origin {
    fun watch(block: (T) -> Unit): Closeable {
        val job = Job()

        onEach {
            block(it)
        }.launchIn(CoroutineScope(Dispatchers.Main + job))

        return object : Closeable {
            override fun close() {
                job.cancel()
            }
        }
    }
}