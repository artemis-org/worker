package io.artemisbot.worker.amqp.http

import com.google.gson.annotations.SerializedName

class Header(
    @SerializedName("key")
    val key: String,
    value: Any
) {
    @SerializedName("value")
    val value = value.toString()
}