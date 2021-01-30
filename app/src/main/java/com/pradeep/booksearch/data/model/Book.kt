package com.pradeep.booksearch.data.model

import com.google.gson.annotations.SerializedName

data class Book(

    @SerializedName("volumeInfo")
    var volumeInfo : VolumeInfo
) {

    data class VolumeInfo(
        @SerializedName("title")
        var title : String? = null,

        @SerializedName("authors")
        var authors : List<String>? = null,

        @SerializedName("publishedDate")
        var publishedDate : String? = null,

        @SerializedName("imageLinks")
        var imageLinks : ImageLinks
    ) {
        data class ImageLinks(
            @SerializedName("smallThumbnail")
            var smallThumbnail : String? = null,

            @SerializedName("thumbnail")
            var thumbnail : String? = null

        )
    }
}