package com.pradeep.booksearch.ui.base

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.IBinder
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.pradeep.booksearch.R
import com.pradeep.booksearch.data.net.NetworkStatusChecker

open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

     fun dismissKeyboard(windowToken: IBinder) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }


    fun getNetworkChecker(): NetworkStatusChecker{
       return NetworkStatusChecker(requireActivity().getSystemService(ConnectivityManager::class.java))
    }

    fun showNetworkAlert(){
        var builder = AlertDialog.Builder(requireContext())
        builder.setTitle(R.string.network_alert)
        builder.setMessage(R.string.network_not_available)
        builder.setNegativeButton("Ok"){ dialog, which ->
            dialog.dismiss()
        }
        var alertDialog : AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}