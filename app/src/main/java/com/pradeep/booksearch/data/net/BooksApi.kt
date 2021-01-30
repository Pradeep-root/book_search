package com.pradeep.booksearch.data.net


import com.pradeep.booksearch.data.model.BooksResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApi {


    @GET("/books/v1/volumes")
    fun searchBooks(@Query("q") query : String,
                    @Query("key")  key : String) : Call<BooksResponse>

}