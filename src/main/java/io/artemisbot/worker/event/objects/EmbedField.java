package io.artemisbot.worker.event.objects;

import com.google.gson.annotations.SerializedName;

public class EmbedField {
    @SerializedName("name")
    public String name;

    @SerializedName("value")
    public String value;

    @SerializedName("inline")
    public boolean inline;
}
