package io.artemisbot.worker

import io.artemisbot.worker.amqp.AmqpManager
import io.artemisbot.worker.config.ConfigType
import io.artemisbot.worker.event.listeners.CommandListener
import io.artemisbot.worker.event.register
import io.artemisbot.worker.redis.EventQueue
import io.artemisbot.worker.redis.RedisManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import java.net.URI

class Worker : Runnable {

    override fun run() {
        // Load config
        val cfg = if(File("config.toml").exists()) {
            ConfigType.TOML.getProvider().load()
        } else {
            ConfigType.ENVVAR.getProvider().load()
        }

        // Start event queue listener
        //RedisManager.connect(cfg)

        // Start httpproxy RPC
        AmqpManager.connect(cfg)

        //CommandListener().register()
        //EventQueue.startListener()
        Thread.currentThread().join()
    }
}