package com.example.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController



class MessageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        val nextButton = view.findViewById<Button>(R.id.next)
        val messageView = view.findViewById<TextView>(R.id.message)
        // Inflate the layout for this fragment
        nextButton.setOnClickListener {
           val message = messageView.text.toString()
           val action = MessageFragmentDirections.actionMessageFragmentToProvaFragment(message)
           view.findNavController().navigate(action)
           // view.findNavController().navigate(R.id.action_messageFragment_to_provaFragment)
        }
        // Inflate the layout for this fragment

        return view
    }


}