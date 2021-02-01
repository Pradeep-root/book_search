package com.pradeep.booksearch.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pradeep.booksearch.data.model.Book
import com.pradeep.booksearch.data.model.BooksResponse
import com.pradeep.booksearch.data.net.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(): BookRepository {

   private var TAG = this.javaClass.simpleName

    private var retrofitClient = RetrofitClient()


    override fun searchBooks(query: String): LiveData<List<Book>?> {
        var data = MutableLiveData<List<Book>>()

        retrofitClient.searchBook(query).enqueue(object : Callback<BooksResponse>{
            override fun onFailure(call: Call<BooksResponse>, t: Throwable) {
                data.value = null
                Log.d(TAG, "Failure")
            }

            override fun onResponse(call: Call<BooksResponse>, response: Response<BooksResponse>) {
                data.value = response.body()?.items
                Log.d(TAG, "Response  ${response.body()?.items}")
            }
        })

        return data
    }

}