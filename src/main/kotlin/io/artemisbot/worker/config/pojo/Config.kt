package io.artemisbot.worker.config.pojo

import io.artemisbot.worker.config.EnvVar

class Config {
    @EnvVar("REDIS_URI")
    lateinit var redisUri: String

    @EnvVar("REDIS_POOL_SIZE")
    var redisPoolSize: Int = 0

    @EnvVar("AMQP_URI")
    lateinit var amqpUri: String

    @EnvVar("AMQP_POOL_SIZE")
    var amqpPoolSize: Int = 0
}
