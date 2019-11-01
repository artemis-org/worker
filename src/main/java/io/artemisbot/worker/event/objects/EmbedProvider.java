package io.artemisbot.worker.event.objects;

import com.google.gson.annotations.SerializedName;

public class EmbedProvider {
    @SerializedName("name")
    public String name;

    @SerializedName("url")
    public String url;
}
