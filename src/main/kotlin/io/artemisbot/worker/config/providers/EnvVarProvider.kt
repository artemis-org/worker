package io.artemisbot.worker.config.providers

import io.artemisbot.worker.Constants
import io.artemisbot.worker.config.ConfigType
import io.artemisbot.worker.config.EnvVar
import io.artemisbot.worker.config.pojo.Config
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.jvm.kotlinProperty

class EnvVarProvider : ConfigProvider() {

    override val type = ConfigType.ENVVAR

    override fun load(): Config {
        val clazz = Config()

        for(field in clazz::class.java.declaredFields) {
            field.isAccessible = true

            val name = field.getAnnotation(EnvVar::class.java)?.name ?: field.name
            val value = System.getenv(Constants.ENVVAR_PREFIX + name) ?: continue // Nullable fields in the Config must be set to null initially

            when(field.type) {
                String::class.java -> field.set(clazz, value)
                Boolean::class.java -> value.toBoolean().apply { field.setBoolean(clazz, this) } // Defaults to false
                Byte::class.java -> value.toByteOrNull()?.apply { field.setByte(clazz, this) }
                Double::class.java -> value.toDoubleOrNull()?.apply { field.setDouble(clazz, this) }
                Float::class.java -> value.toFloatOrNull()?.apply { field.setFloat(clazz, this) }
                Int::class.java -> value.toIntOrNull()?.apply { field.setInt(clazz, this) }
                Long::class.java -> value.toLongOrNull()?.apply { field.setLong(clazz, this) }
                Short::class.java -> value.toShortOrNull()?.apply { field.setShort(clazz, this) }
            }
        }

        return clazz
    }
}