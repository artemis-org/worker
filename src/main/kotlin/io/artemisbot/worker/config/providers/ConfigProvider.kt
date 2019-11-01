package io.artemisbot.worker.config.providers

import io.artemisbot.worker.config.ConfigType
import io.artemisbot.worker.config.pojo.Config

abstract class ConfigProvider {
    abstract val type: ConfigType

    abstract fun load(): Config
}