package com.example.kotlinapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.kotlinapp.R
import com.example.kotlinapp.adapters.UserAdapter
import com.example.kotlinapp.models.User

class ListeFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.liste_fragment, container, false)

        val user1 = User(
            id = 1,
            name = "Didier Talon",
            username = "Didier01",
            email = "",
            phone = "",
            website = "didier.fr",
            lat = 0.0,
            lng = 0.0
        )

        val user2 = User(
            id = 2,
            name = "Raymond Dotek",
            username = "Raymond01",
            email = "",
            phone = "",
            website = "raymond.fr",
            lat = 0.0,
            lng = 0.0
        )

        val users = mutableListOf<User>(user1, user2)

        val listView = v.findViewById<ListView>(R.id.list_view)
        val adapter = UserAdapter(users, requireActivity())
        listView.adapter = adapter

        return v
    }
}