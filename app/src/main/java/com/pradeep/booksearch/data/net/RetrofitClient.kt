package com.pradeep.booksearch.data.net

import com.pradeep.booksearch.data.model.BooksResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val booksApi : BooksApi

    companion object{
        private const val KEY = "AIzaSyBdM0y_nEe-JPKBA2sGVZJDd-E2wTMUPPQ"
        private const val GOOGLE_API_BASE_URL = "https://www.googleapis.com"
    }


    init {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(GOOGLE_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        booksApi = retrofit.create(BooksApi::class.java)
    }

    fun searchBook(query : String): Call<BooksResponse>{
        return booksApi.searchBooks(key = KEY, query = query )
    }
}