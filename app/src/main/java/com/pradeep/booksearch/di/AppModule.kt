package com.pradeep.booksearch.di

import com.pradeep.booksearch.BookApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val app : BookApplication) {

    @Provides
    @Singleton
    fun provideApp() = app
}