package io.artemisbot.worker.amqp

import com.rabbitmq.client.Channel
import io.artemisbot.worker.Constants
import java.util.*

class Publisher(val pool: ConnectionPool) {

    private var chan: Channel? = null

    fun connect() {
        pool.getConnection().use {
            chan = createChannel()
            chan?.createQueue(Constants.AMQP_OUTBOUND)
        }
    }

    fun publish(content: String, correlationId: UUID) = chan?.basicPublish("", Constants.AMQP_OUTBOUND, AmqpManager.buildProperties(correlationId), content.toByteArray())
}