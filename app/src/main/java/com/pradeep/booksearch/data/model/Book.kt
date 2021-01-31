package com.pradeep.booksearch.data.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.gson.annotations.SerializedName
import com.pradeep.booksearch.R
import com.squareup.picasso.Picasso

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
         class ImageLinks(
            @SerializedName("smallThumbnail")
            var smallThumbnail : String? = null,

            @SerializedName("thumbnail")
            var thumbnail : String? = null

        )

        fun authorNames() : String? {
            if(authors == null){
               // return Resources.getSystem().getString(R.string.author_info_not_available)
                return "Author information not available"
            }
            return authors?.joinToString(separator = ",")
        }
    }
}

@BindingAdapter("imageUrl")
fun loadCover(view : ImageView, url : String?){
    Picasso.get().load(url).placeholder(R.drawable.book_cover_placeholder).error(R.drawable.ic_image_load_error).into(view)

}