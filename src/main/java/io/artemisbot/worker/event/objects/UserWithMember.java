package io.artemisbot.worker.event.objects;

import com.google.gson.annotations.SerializedName;

public class UserWithMember extends User {
    @SerializedName("member")
    public Member member;
}
