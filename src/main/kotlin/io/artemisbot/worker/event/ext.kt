package io.artemisbot.worker.event

inline fun<reified T: Event> Listener<T>.register() = EventBus.listen<T>().subscribe(this::onEvent)