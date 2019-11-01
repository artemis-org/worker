package io.artemisbot.worker.event

interface Listener<T: Event> {
    fun onEvent(e: T)
}