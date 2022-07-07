package com.example.kotlinapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.kotlinapp.R

class FirstFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.first_fragment, container, false)
        val button = v.findViewById<Button>(R.id.button)

        button.setOnClickListener(View.OnClickListener {
            // Get edit_text text and create Bundle
            val editText = v.findViewById<EditText>(R.id.edit_text)
            val b = Bundle()
            b.putString("text_edit_content", editText.text.toString())

            // Instantiate fragment to update and pass it the bundle
            val second_fragment = SecondFragment()
            second_fragment.arguments = b

            // Change fragment in activity
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.frame_layout, second_fragment)?.commit()
        })
        return v
    }
}