package com.pradeep.booksearch.ui.booksearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pradeep.booksearch.data.BookRepository
import com.pradeep.booksearch.data.BookRepositoryImpl
import com.pradeep.booksearch.data.model.Book

class BookSearchViewModel(private var repository: BookRepository = BookRepositoryImpl()) : ViewModel() {


    fun searchBooks(query : String) : LiveData<List<Book>?>{
        return repository.searchBooks(query)
    }

}