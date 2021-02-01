package com.pradeep.booksearch

import android.app.Application
import com.pradeep.booksearch.di.AppComponent
import com.pradeep.booksearch.di.AppModule
import com.pradeep.booksearch.di.DaggerAppComponent

class BookApplication : Application(){

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)

    }

    private fun initDagger(app : BookApplication) : AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()

}