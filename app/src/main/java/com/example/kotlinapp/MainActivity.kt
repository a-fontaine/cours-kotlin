package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinapp.UI.FirstFragment
import com.example.kotlinapp.UI.ListeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstFragment = FirstFragment()
        val listFragment = ListeFragment()
        supportFragmentManager?.beginTransaction()?.replace(R.id.frame_layout, listFragment)?.commit()
    }
}