package io.artemisbot.worker.event.objects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Embed {
    @SerializedName("title")
    public String title;

    @SerializedName("type")
    public String type;

    @SerializedName("description")
    public String description;

    @SerializedName("url")
    public String url;

    @SerializedName("timestamp")
    public String timestamp;

    @SerializedName("color")
    public int colour;

    @SerializedName("footer")
    public EmbedFooter footer;

    @SerializedName("image")
    public EmbedImage image;

    @SerializedName("thumbnail")
    public EmbedThumbnail thumbnail;

    @SerializedName("video")
    public EmbedVideo video;

    @SerializedName("provider")
    public EmbedProvider provider;

    @SerializedName("author")
    public EmbedAuthor author;

    @SerializedName("fields")
    public List<EmbedField> fields;
}
