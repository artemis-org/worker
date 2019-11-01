package io.artemisbot.worker.redis

import com.google.gson.GsonBuilder
import io.artemisbot.worker.event.Event
import io.artemisbot.worker.event.EventBus
import io.artemisbot.worker.event.EventManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object EventQueue {

    private val gson = GsonBuilder().create()

    fun startListener() {
        RedisManager.run {
            GlobalScope.launch {
                while(true) {
                    val raw = blpop(0, "sharder:from")[1]

                    val map = gson.fromJson(raw, Map::class.java)

                    val name = map["t"] as String

                    val clazz = EventManager.getEventClassByName(name) ?: return@launch
                    val event = gson.fromJson(raw, clazz) as Event

                    EventBus.publish(event)
                }
            }
        }
    }
}