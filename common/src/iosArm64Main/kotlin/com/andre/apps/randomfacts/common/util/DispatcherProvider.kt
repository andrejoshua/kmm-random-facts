package com.andre.apps.randomfacts.common.util

import kotlinx.coroutines.CoroutineDispatcher

actual interface DispatcherProvider {
    actual fun main(): CoroutineDispatcher = NSMainDispatcher()

    actual fun default(): CoroutineDispatcher = NSMainDispatcher()

    actual fun io(): CoroutineDispatcher = NSMainDispatcher()

    actual fun unconfined(): CoroutineDispatcher = NSMainDispatcher()
}