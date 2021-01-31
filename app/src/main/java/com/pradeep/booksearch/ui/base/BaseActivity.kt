package com.pradeep.booksearch.ui.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.pradeep.booksearch.R

open class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    fun setToolbar(toolbar : Toolbar, @StringRes title : Int){
        toolbar.setTitle(title)
        toolbar.setTitleTextColor(getColor(R.color.white))
        setSupportActionBar(toolbar)
    }
}