package io.artemisbot.worker.amqp

import com.rabbitmq.client.Channel
import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory
import io.artemisbot.worker.config.pojo.Config
import io.artemisbot.worker.utils.Callback
import java.lang.IllegalArgumentException
import java.net.URI
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class AmqpConnectionPool(val config: Config) : ConnectionPool {

    private val factory = ConnectionFactory().apply {
        setUri(URI(config.amqpUri))
    }

    private val freeConnections = mutableListOf<Connection>()

    private val freeLock = ReentrantLock()
    private val condition = freeLock.newCondition()

    override fun connect(cb: Callback<Connection>) {
        for (i in 0 until config.amqpPoolSize) {
            val conn = createConnection()
            freeConnections.add(conn)
            cb(conn)
        }
    }

    override fun getConnection(): WrappedConnection {
        if (freeConnections.isEmpty()) {
            freeLock.withLock {
                condition.await()
            }
        }

        val conn = WrappedConnection(freeConnections.removeAt(freeConnections.size - 1)) {
            freeConnections.add(it)
            if (freeConnections.size == 1) {
                freeLock.withLock {
                    condition.signal()
                }
            }
        }

        return conn
    }

    private fun createConnection() = factory.newConnection()
}