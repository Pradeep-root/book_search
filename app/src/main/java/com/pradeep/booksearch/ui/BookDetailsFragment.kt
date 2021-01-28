package com.pradeep.booksearch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pradeep.booksearch.R
import com.pradeep.booksearch.ui.base.BaseFragment

class BookDetailsFragment : BaseFragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_details, container, false)
    }

}