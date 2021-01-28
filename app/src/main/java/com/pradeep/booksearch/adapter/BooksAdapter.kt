package com.pradeep.booksearch.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pradeep.booksearch.Book

class BooksAdapter(private var books : ArrayList<Book>) : RecyclerView.Adapter<BooksAdapter.BookHolderView>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksAdapter.BookHolderView {
        TODO("Not yet implemented")
    }

    inner class BookHolderView(view: View) : RecyclerView.ViewHolder(view){
        // TODO data binding here

    }

    override fun getItemCount(): Int {
       return 10
    }

    override fun onBindViewHolder(holder: BooksAdapter.BookHolderView, position: Int) {
        TODO("Not yet implemented")
    }


}