package io.artemisbot.worker.event.objects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Member {
    @SerializedName("user")
    public User user;

    @SerializedName("nick")
    public String nickname;

    @SerializedName("roles")
    public List<Long> roles;

    @SerializedName("joined_at")
    public String joinedAt;

    @SerializedName("deaf")
    public boolean deaf;

    @SerializedName("mute")
    public boolean mute;
}
