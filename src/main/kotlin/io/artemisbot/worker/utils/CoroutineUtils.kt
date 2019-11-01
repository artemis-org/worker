package io.artemisbot.worker.utils

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
fun<T> Deferred<T>.onComplete(block: (T) -> Unit) = invokeOnCompletion { block(getCompleted()) }
