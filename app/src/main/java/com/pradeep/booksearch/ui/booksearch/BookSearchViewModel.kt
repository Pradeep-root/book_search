package com.pradeep.booksearch.ui.booksearch

import android.view.View
import android.widget.FrameLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pradeep.booksearch.data.BookRepository
import com.pradeep.booksearch.data.BookRepositoryImpl
import com.pradeep.booksearch.data.model.Book

class BookSearchViewModel(private var repository: BookRepository = BookRepositoryImpl()) : ViewModel() {


    var searchText = ObservableField<String>("")
    private var searchResultLiveData = MediatorLiveData<List<Book>>()

    var showProgressBar = ObservableField<Boolean>()

    fun searchedResult(): LiveData<List<Book>?>{
        return searchResultLiveData
    }

    fun searchBooks(){
        showProgressBar.set(true)

        searchResultLiveData.addSource(repository.searchBooks(query = searchText.get()?:"")){
            searchResultLiveData.postValue(it)
            showProgressBar.set(false)
        }
    }

    companion object{
        @JvmStatic
        @BindingAdapter("app:goneUnless")
        fun goneUnless(view: View, visible: Boolean) {
            view.visibility = if (visible) View.VISIBLE else View.GONE
        }
    }

}