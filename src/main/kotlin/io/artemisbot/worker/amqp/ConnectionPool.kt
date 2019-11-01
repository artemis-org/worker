package io.artemisbot.worker.amqp

import com.rabbitmq.client.Connection
import io.artemisbot.worker.utils.Callback

interface ConnectionPool {
    fun connect(cb: Callback<Connection>)
    fun getConnection(): WrappedConnection
}