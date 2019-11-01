package io.artemisbot.worker.amqp.http

import com.google.gson.annotations.SerializedName
import java.util.*

class HttpRequest(
    endpoint: Endpoint,
    @SerializedName("values")
    val values: List<String>,
    requestType: RequestType,
    @SerializedName("headers")
    val headers: List<Header>
) {
    @SerializedName("endpoint")
    val endpoint = endpoint.endpoint

    @SerializedName("request_type")
    val requestType = requestType.raw

    @SerializedName("correlation_id")
    val correlationId = UUID.randomUUID()
}