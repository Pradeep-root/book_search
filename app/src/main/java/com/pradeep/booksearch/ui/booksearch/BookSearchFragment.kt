package com.pradeep.booksearch.ui.booksearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pradeep.booksearch.data.model.Book
import com.pradeep.booksearch.R
import com.pradeep.booksearch.adapter.BooksAdapter
import com.pradeep.booksearch.databinding.FragmentBookSearchBinding
import com.pradeep.booksearch.ui.base.BaseFragment

class BookSearchFragment : BaseFragment() {

    private lateinit var binding: FragmentBookSearchBinding
    private lateinit var viewModel: BookSearchViewModel
    private lateinit var adapter : BooksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater
                , R.layout.fragment_book_search, container, false)

        var rootView = binding.root
        viewModel = ViewModelProvider(requireActivity()).get(BookSearchViewModel::class.java)

        configureBookList()
        searchBook()
        return rootView
    }

    private fun searchBook() {
        viewModel.searchBooks("flowers").observe(requireActivity(), Observer { books : List<Book>? ->
            if(books == null){
               // TODO show msg result not found
            }else{
                adapter.updateList(books)
            }
        })
    }

    private fun configureBookList() {
        binding.recyclerViewBooks.layoutManager = LinearLayoutManager(requireContext())
        var itemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        itemDecoration.setDrawable(resources.getDrawable(R.drawable.divider_layer, null))
        binding.recyclerViewBooks.addItemDecoration(itemDecoration)
        adapter = BooksAdapter(mutableListOf())
        binding.recyclerViewBooks.adapter = adapter
    }

}