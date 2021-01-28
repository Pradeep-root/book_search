package com.pradeep.booksearch.ui

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.pradeep.booksearch.Book
import com.pradeep.booksearch.R
import com.pradeep.booksearch.adapter.BooksAdapter
import com.pradeep.booksearch.databinding.FragmentBookSearchBinding
import com.pradeep.booksearch.ui.base.BaseFragment

class BookSearchFragment : BaseFragment() {

    private lateinit var binding: FragmentBookSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater
                , R.layout.fragment_book_search, container, false)
        var rootView = binding.root

        configureBookList()
        return rootView
    }

    private fun configureBookList() {
        binding.recyclerViewBooks.layoutManager = LinearLayoutManager(requireContext())
        var itemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        itemDecoration.setDrawable(resources.getDrawable(R.drawable.divider_layer, null))
        binding.recyclerViewBooks.addItemDecoration(itemDecoration)
        binding.recyclerViewBooks.adapter = BooksAdapter(ArrayList<Book>())
    }

}