package io.artemisbot.worker.event.objects;

import com.google.gson.annotations.SerializedName;

public class EmbedImage {
    @SerializedName("url")
    public String url;

    @SerializedName("proxy_url")
    public String proxyUrl;

    @SerializedName("height")
    public int height;

    @SerializedName("width")
    public int width;
}
