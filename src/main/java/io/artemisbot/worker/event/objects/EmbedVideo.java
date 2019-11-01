package io.artemisbot.worker.event.objects;

import com.google.gson.annotations.SerializedName;

public class EmbedVideo {
    @SerializedName("url")
    public String url;

    @SerializedName("height")
    public int height;

    @SerializedName("width")
    public int width;
}
