package com.pradeep.booksearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pradeep.booksearch.R
import com.pradeep.booksearch.data.model.Book
import com.pradeep.booksearch.databinding.ItemLyoutBooksBinding

class BooksAdapter(private var books : MutableList<Book>) : RecyclerView.Adapter<BooksAdapter.BookHolderView>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksAdapter.BookHolderView {
         var layoutInflater = LayoutInflater.from(parent.context)
         var binding = DataBindingUtil.inflate(layoutInflater,
             R.layout.item_lyout_books, parent, false) as ItemLyoutBooksBinding
         return BookHolderView(binding)
    }

    inner class BookHolderView(private var binding: ItemLyoutBooksBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(book: Book){
            binding.book = book // set data on ui using binding
        }
    }

    override fun getItemCount(): Int {
       return books.size
    }

    override fun onBindViewHolder(holder: BooksAdapter.BookHolderView, position: Int) {
         var book = books.get(position)
         holder.bind(book)
    }

    fun updateList(newList : List<Book>){
        books.clear()
        books.addAll(newList)
        notifyDataSetChanged()
    }

}