import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.3.11"
}

group = "io.artemisbot.worker"
version = "1.0-SNAPSHOT"

application {
    mainClassName = "io.artemisbot.worker.mainKt"
}

repositories {
    mavenCentral()
    maven(url="https://repo.spring.io/milestone")
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1")
    compile("io.reactivex.rxjava2:rxjava:2.2.9")
    compile("com.moandjiezana.toml:toml4j:0.7.2")
    compile("redis.clients:jedis:3.1.0-m1")
    compile("org.slf4j:slf4j-log4j12:1.7.26")
    compile("com.google.code.gson:gson:2.8.5")
    compile("com.rabbitmq:amqp-client:5.7.1")
    compile("commons-dbcp:commons-dbcp:1.4")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}