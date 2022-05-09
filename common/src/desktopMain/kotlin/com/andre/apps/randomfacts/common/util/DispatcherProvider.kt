package com.andre.apps.randomfacts.common.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual interface DispatcherProvider {
    actual fun main(): CoroutineDispatcher = Dispatchers.Main

    actual fun default(): CoroutineDispatcher = Dispatchers.Default

    actual fun io(): CoroutineDispatcher = Dispatchers.IO

    actual fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}