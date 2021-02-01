package com.pradeep.booksearch.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.pradeep.booksearch.R
import com.pradeep.booksearch.databinding.ActivityMainBinding
import com.pradeep.booksearch.ui.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding : ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main)
        setToolbar(binding.toolbar, R.string.book_search_title)
    }

}