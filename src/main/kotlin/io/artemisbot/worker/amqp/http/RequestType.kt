package io.artemisbot.worker.amqp.http

enum class RequestType(val raw: String) {
    GET("GET"),
    POST("POST"),
    PATCH("PATCH"),
    PUT("PUT"),
    DELETE("DELETE"),
}