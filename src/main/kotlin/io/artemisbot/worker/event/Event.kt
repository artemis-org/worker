package io.artemisbot.worker.event

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

abstract class Event {
    val gson = GsonBuilder().create()

    @SerializedName("d")
    lateinit var raw: JsonElement

    inline fun<reified T> getData(): T = gson.fromJson(raw, T::class.java)
}