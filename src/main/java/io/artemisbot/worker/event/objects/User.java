package io.artemisbot.worker.event.objects;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    public String id;

    @SerializedName("username")
    public String username;

    @SerializedName("discriminator")
    public String discriminator;

    @SerializedName("avatar")
    public String avatar;
}
