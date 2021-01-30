package com.pradeep.booksearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pradeep.booksearch.data.model.Book
import com.pradeep.booksearch.databinding.ItemLyoutBooksBinding

class BooksAdapter(private var books : ArrayList<Book>) : RecyclerView.Adapter<BooksAdapter.BookHolderView>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksAdapter.BookHolderView {
         var layoutInflater = LayoutInflater.from(parent.context)
         var binding = ItemLyoutBooksBinding.inflate(layoutInflater, parent, false)
         return BookHolderView(binding)
    }

    inner class BookHolderView(binding: ItemLyoutBooksBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(book: Book){
            //TODO set data here
        }

    }

    override fun getItemCount(): Int {
       return 10
    }

    override fun onBindViewHolder(holder: BooksAdapter.BookHolderView, position: Int) {
        // var book = books.get(position)
         holder.bind(Book())
    }

}