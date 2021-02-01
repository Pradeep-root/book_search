package com.pradeep.booksearch.di

import com.pradeep.booksearch.ui.booksearch.BookSearchFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class, BookSearchViewModelModule::class, RepositoryModule::class))
interface AppComponent {

    fun inject(target: BookSearchFragment)
}