package com.example.kotlinapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kotlinapp.R

class SecondFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.second_fragment, container, false)
        val b = arguments
        var reception = b?.getString("text_edit_content")

        val textView = v.findViewById<TextView>(R.id.text_view)
        textView.text = reception

        return v
    }
}