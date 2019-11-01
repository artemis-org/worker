package io.artemisbot.worker.amqp

import com.rabbitmq.client.Channel
import com.rabbitmq.client.Connection
import io.artemisbot.worker.utils.Callback
import java.io.Closeable

class WrappedConnection(val connection: Connection, val cb: Callback<Connection>): Closeable {

    fun use(block: Connection.() -> Unit) = connection.use(block)

    override fun close() {
        cb(connection)
    }
}