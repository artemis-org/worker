package io.artemisbot.worker.event.listeners

import io.artemisbot.worker.Constants
import io.artemisbot.worker.commands.commands
import io.artemisbot.worker.event.Listener
import io.artemisbot.worker.event.events.MessageCreateEvent
import io.artemisbot.worker.event.objects.Message

class CommandListener : Listener<MessageCreateEvent> {

    override fun onEvent(e: MessageCreateEvent) {
        val data = e.getData<Message>()
        val content = data.content

        if(!content.startsWith(Constants.COMMAND_PREFIX)) return

        val split = content.split(" ").toTypedArray()
        val root = split[0].substringAfter(Constants.COMMAND_PREFIX)
        val args =
                if(split.size == 1) emptyArray()
                else split.copyOfRange(1, split.size)

    }
}