package io.artemisbot.worker.event.objects;

import com.google.gson.annotations.SerializedName;

public class EmbedFooter {
    @SerializedName("text")
    public String text;

    @SerializedName("icon_url")
    public String iconUrl;

    @SerializedName("proxy_icon_url")
    public String proxyIconUrl;
}
