package io.artemisbot.worker.event.objects;

import com.google.gson.annotations.SerializedName;

public class EmbedAuthor {
    @SerializedName("name")
    public String name;

    @SerializedName("url")
    public String url;

    @SerializedName("icon_url")
    public String iconUrl;

    @SerializedName("proxy_icon_url")
    public String proxyIconUrl;
}
