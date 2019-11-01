package io.artemisbot.worker.amqp

import com.rabbitmq.client.AMQP
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope
import com.rabbitmq.client.Channel
import io.artemisbot.worker.Constants
import io.artemisbot.worker.config.pojo.Config
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.CountDownLatch

// TODO: Handle exceptions
object AmqpManager {

    private lateinit var pool: ConnectionPool
    private lateinit var publisher: Publisher

    fun connect(config: Config) {
        pool = AmqpConnectionPool(config)

        val latch = CountDownLatch(config.amqpPoolSize)
        pool.connect {
            latch.countDown()
        }
        latch.await()

        GlobalScope.launch { createConsumer() }
        /*GlobalScope.launch {
            publisher = Publisher(pool)
            publisher.connect()
        }*/
    }

    fun createConsumer() {
        pool.getConnection().use {
            val chan = createChannel()
            val queue = chan.createQueue(Constants.AMQP_INBOUND)
            println("ccccc")

            val consumer = object : DefaultConsumer(chan) {
                override fun handleDelivery(
                    consumerTag: String?,
                    envelope: Envelope?,
                    properties: AMQP.BasicProperties?,
                    body: ByteArray?
                ) {
                    println("aaaa")
                    val correlationId = properties?.correlationId ?: return
                    println(correlationId)
                    val content = body?.toString(Charsets.UTF_8) ?: return

                    println(content)
                }
            }
            println("bbb")

            println(queue.queue)
            chan.basicQos(0, 0, false)
            chan.basicConsume(queue.queue, true, consumer)
        }
    }

    /**
     * @return The correlation ID
     */
    fun publish(raw: String): UUID {
        val correlationId = UUID.randomUUID()

        GlobalScope.launch {
            pool.getConnection().use {
                publisher.publish(raw, correlationId)
            }
        }

        return correlationId
    }

    // TODO: Improve this
    fun disconnect(channel: Channel) {
        if (channel.isOpen()) channel.close()
        pool.close();
    }

    fun buildProperties(correlationId: UUID) = AMQP.BasicProperties(
        null, null, null, null, null, correlationId.toString(), null, null, null, null, null, null, null, null
    )
}