package com.pradeep.booksearch.di

import com.pradeep.booksearch.data.BookRepository
import com.pradeep.booksearch.ui.booksearch.BookSearchViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class BookSearchViewModelModule {

    @Provides
    @Singleton
    fun provideBookSearchViewModel(repository : BookRepository)
            : BookSearchViewModel = BookSearchViewModel(repository)

}