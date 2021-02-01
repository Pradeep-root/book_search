package com.pradeep.booksearch.ui.bookdetails

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.pradeep.booksearch.R
import com.pradeep.booksearch.adapter.BooksAdapter
import com.pradeep.booksearch.databinding.ActivityBookDetailsBinding
import com.pradeep.booksearch.ui.base.BaseActivity

class BookDetailsActivity : BaseActivity() {

    lateinit var binding : ActivityBookDetailsBinding
    lateinit var infoLink : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(this, R.layout.activity_book_details)
         setToolbar(binding.toolbarBookDetail, R.string.detail_screen_title)

         supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        infoLink = intent.getStringExtra(BooksAdapter.INFO_LINK_PUT_EXTRA_KEY).toString()
        loadWebDetailOnWeb()
    }

    private fun loadWebDetailOnWeb() {
        binding.wvDetails.webViewClient = WebViewClient()
        binding.wvDetails.loadUrl(infoLink)
        val webSettings = binding.wvDetails.settings
        webSettings.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        if (binding.wvDetails!!.canGoBack()) {
            binding.wvDetails.goBack()
        } else {
            super.onBackPressed()
        }
    }
}