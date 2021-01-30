package com.pradeep.booksearch.ui

import android.os.Bundle
import androidx.navigation.findNavController
import com.pradeep.booksearch.R
import com.pradeep.booksearch.ui.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.nav_host_fragment).navigateUp()


}