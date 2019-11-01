package io.artemisbot.worker.redis

import io.artemisbot.worker.config.pojo.Config
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool

object RedisManager {

    private val poolFactory = PoolFactory()
    private var pool: JedisPool? = null

    fun connect(config: Config) {
        pool = poolFactory.getPool(config)
    }

    fun run(block: Jedis.() -> Unit) = pool?.resource?.use(block)
    fun<T> run(block: Jedis.() -> T): T? = pool?.resource?.use(block)

    fun isConnected() = run<Boolean> { isConnected } == true
}