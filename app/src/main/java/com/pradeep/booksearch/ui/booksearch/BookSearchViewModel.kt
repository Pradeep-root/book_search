package com.pradeep.booksearch.ui.booksearch

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.pradeep.booksearch.data.BookRepository
import com.pradeep.booksearch.data.BookRepositoryImpl
import com.pradeep.booksearch.data.model.Book

class BookSearchViewModel(private var repository: BookRepository = BookRepositoryImpl()) : ViewModel() {


    var searchText = ObservableField<String>("")
    private var searchResultLiveData = MediatorLiveData<List<Book>>()

    fun searchedResult(): LiveData<List<Book>?>{
        return searchResultLiveData
    }

    fun searchBooks(){
        searchResultLiveData.addSource(repository.searchBooks(query = searchText.get()?:"")){
            searchResultLiveData.postValue(it)
        }
    }

}