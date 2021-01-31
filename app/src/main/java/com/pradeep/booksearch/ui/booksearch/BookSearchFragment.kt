package com.pradeep.booksearch.ui.booksearch

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pradeep.booksearch.R
import com.pradeep.booksearch.adapter.BooksAdapter
import com.pradeep.booksearch.data.model.Book
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

        binding.searchViewModel = viewModel

        configureBookList()
        searchBook()
        loadSearchedBook()
        searchTextWatcher()
        return rootView
    }

    private fun searchTextWatcher() {
        binding.editBookSearch.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.btnSearch.isEnabled = count > 0
                binding.btnSearch.isClickable = count > 0
            }
        })
    }


    private fun searchBook() {
        binding.btnSearch.setOnClickListener {
            dismissKeyboard(binding.root.windowToken)
            if(getNetworkChecker().hasNetworkConnection()){
                viewModel.searchBooks()
            }else{
                showNetworkAlert()
            }
        }
    }

    private fun loadSearchedBook() {
        viewModel.searchedResult().observe(requireActivity(), Observer { books : List<Book>? ->
            if(books == null){
               adapter.updateList(mutableListOf())
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