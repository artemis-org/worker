package io.artemisbot.worker.utils

import io.artemisbot.worker.event.objects.*

fun embed(block: Embed.() -> Unit) = Embed().also(block)

open class EmbedBuilder {

    var title: String? = null
    var type: String? = null
    var description: String? = null
    var url: String? = null
    var timestamp: String? = null
    var colour: Int? = null

    private var footer: EmbedFooter? = null
    private var image: EmbedImage? = null
    private var thumbnail: EmbedThumbnail? = null
    private var video: EmbedVideo? = null
    private var provider: EmbedProvider? = null
    private var author: EmbedAuthor? = null
    private var fields: MutableList<EmbedField>? = null

    fun footer(block: EmbedFooter.() -> Unit) {
        footer = EmbedFooter().also(block)
    }

    fun image(block: EmbedImage.() -> Unit) {
        image = EmbedImage().also(block)
    }

    fun thumbnail(block: EmbedThumbnail.() -> Unit) {
        thumbnail = EmbedThumbnail().also(block)
    }

    fun video(block: EmbedVideo.() -> Unit) {
        video = EmbedVideo().also(block)
    }

    fun provider(block: EmbedProvider.() -> Unit) {
        provider = EmbedProvider().also(block)
    }
    
    fun author(block: EmbedAuthor.() -> Unit) {
        author = EmbedAuthor().also(block)
    }
    
    fun field(block: EmbedField.() -> Unit) {
        val field = EmbedField().also(block)
        if(fields == null) fields = mutableListOf(field)
        else fields!!.add(field)
    }

    fun build() = Embed().apply {
        title = this@EmbedBuilder.title
        type = this@EmbedBuilder.type
        description = this@EmbedBuilder.description
        timestamp = this@EmbedBuilder.timestamp
        url = this@EmbedBuilder.url
        colour = this@EmbedBuilder.colour ?: 0
        footer = this@EmbedBuilder.footer
        image = this@EmbedBuilder.image
        thumbnail = this@EmbedBuilder.thumbnail
        video = this@EmbedBuilder.video
        provider = this@EmbedBuilder.provider
        author = this@EmbedBuilder.author
        fields = this@EmbedBuilder.fields
    }
}