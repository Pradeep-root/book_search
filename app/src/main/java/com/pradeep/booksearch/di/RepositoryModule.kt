package com.pradeep.booksearch.di

import com.pradeep.booksearch.data.BookRepository
import com.pradeep.booksearch.data.BookRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository() : BookRepository = BookRepositoryImpl()

}