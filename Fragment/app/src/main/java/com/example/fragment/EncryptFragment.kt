package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



class EncryptFragment : Fragment() {


    class EncryptFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
      //      val view = inflater.inflate(R.layout.fragment_encrypt, container, false)
        /*    val message = EncryptFragmentArgs.fromBundle(requireArguments()).message
            val ecryptedView =  view.findViewById<TextView>(R.id.encrypted_message)
            ecryptedView.text = message.reversed()*/
            return view
        }

    }

}