package com.pradeep.booksearch.data

import androidx.lifecycle.LiveData
import com.pradeep.booksearch.data.model.Book

interface BookRepository {

    fun searchBooks(query: String): LiveData<List<Book>?>
}