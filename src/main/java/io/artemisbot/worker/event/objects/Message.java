package io.artemisbot.worker.event.objects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Message {
    @SerializedName("id")
    public String id;

    @SerializedName("channel_id")
    public String channelId;

    @SerializedName("guild_id")
    public String guildId;

    @SerializedName("author")
    public User author;

    @SerializedName("member")
    public Member member;

    @SerializedName("content")
    public String content;

    @SerializedName("timestamp")
    public String timestamp;

    @SerializedName("edited_timestamp")
    public String editedTimestamp;

    @SerializedName("tts")
    public boolean tts;

    @SerializedName("mention_everyone")
    public boolean mentionsEveryone;

    @SerializedName("mentions")
    public List<UserWithMember> mentionedMembers;

    @SerializedName("mentions_roles")
    public List<Long> mentionedRoles;

    @SerializedName("attachments")
    public List<Attachment> attachments;

    @SerializedName("embeds")
    public List<Embed> embeds;
}
