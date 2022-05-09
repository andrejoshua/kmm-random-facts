package com.andre.apps.randomfacts.common.util

import kotlinx.coroutines.CoroutineDispatcher

expect interface DispatcherProvider {

    open fun main(): CoroutineDispatcher
    open fun default(): CoroutineDispatcher
    open fun io(): CoroutineDispatcher
    open fun unconfined(): CoroutineDispatcher
}

class DefaultDispatcherProvider : DispatcherProvider