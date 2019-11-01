package io.artemisbot.worker.amqp

import com.rabbitmq.client.Channel

fun Channel.createQueue(queue: String) = queueDeclare(queue, true, false, false, null)
