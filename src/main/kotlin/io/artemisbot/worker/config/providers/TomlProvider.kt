package io.artemisbot.worker.config.providers

import com.moandjiezana.toml.Toml
import io.artemisbot.worker.config.ConfigType
import io.artemisbot.worker.config.pojo.Config
import java.io.File

class TomlProvider : ConfigProvider() {
    
    override val type = ConfigType.TOML

    override fun load() = Toml().read(File("config.toml")).to(Config::class.java)
}