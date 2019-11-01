package io.artemisbot.worker.event

import io.artemisbot.worker.event.events.MessageCreateEvent

object EventManager {

    private val events = mapOf<String, Class<out Event>>(
        "MESSAGE_CREATE" to MessageCreateEvent::class.java
    )

    fun getEventClassByName(name: String) = events[name]
}