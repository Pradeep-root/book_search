package com.pradeep.booksearch.ui.base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.IBinder
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pradeep.booksearch.data.net.NetworkStatusChecker

open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

     fun dismissKeyboard(windowToken: IBinder) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }


    fun networkCheck(){
        if(NetworkStatusChecker(requireActivity().getSystemService(ConnectivityManager::class.java)).hasNetworkConnection()){
            Toast.makeText(context, "connect", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "No", Toast.LENGTH_LONG).show()
        }
    }
}