package io.artemisbot.worker.utils

fun<T, U> Map<T, List<U>>.getListOrEmpty(key: T) = this[key] ?: listOf()
fun<T, U> Map<T, Set<U>>.getSetOrEmpty(key: T) = this[key] ?: setOf()

fun<T> Set<T>.with(vararg elements: T) = plus(elements).toSet()