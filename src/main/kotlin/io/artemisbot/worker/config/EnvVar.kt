package io.artemisbot.worker.config

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class EnvVar(val name: String)