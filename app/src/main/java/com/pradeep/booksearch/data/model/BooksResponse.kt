package com.pradeep.booksearch.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BooksResponse(
    @SerializedName("items")
    @Expose
    var items : List<Book>? = null
)