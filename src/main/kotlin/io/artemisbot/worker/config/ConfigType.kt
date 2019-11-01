package io.artemisbot.worker.config

import io.artemisbot.worker.config.providers.ConfigProvider
import io.artemisbot.worker.config.providers.EnvVarProvider
import io.artemisbot.worker.config.providers.TomlProvider

enum class ConfigType {
    ENVVAR,
    TOML,
    ;

    private companion object {
        val envVarProvider = EnvVarProvider()
        val tomlProvider = TomlProvider()
    }

    fun getProvider(): ConfigProvider {
        return when(this) {
            ENVVAR -> envVarProvider
            TOML -> tomlProvider
        }
    }
}