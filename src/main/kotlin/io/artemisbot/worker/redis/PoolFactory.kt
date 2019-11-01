package io.artemisbot.worker.redis

import io.artemisbot.worker.config.pojo.Config
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig
import java.net.URI

class PoolFactory {

    fun getPool(config: Config): JedisPool {
        val jedisConfig = JedisPoolConfig()

        jedisConfig.maxTotal = config.redisPoolSize
        jedisConfig.maxIdle = config.redisPoolSize

        return JedisPool(jedisConfig, URI.create(config.redisUri))
    }
}