package com.example.kotlinapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.kotlinapp.API.ApiClient
import com.example.kotlinapp.R
import com.example.kotlinapp.adapters.UserAdapter
import com.example.kotlinapp.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

        getListOfUser(v)

        return v
    }

    fun getListOfUser(v:View) {
        GlobalScope.launch(Dispatchers.Main) {
            val apiClient = ApiClient()
            val response = apiClient.apiService.getUsers()

            if(response.isSuccessful && response.body() != null){
                val content = response.body()
                val list = content as MutableList<User>

                val listView = v.findViewById<ListView>(R.id.list_view)
                val adapter = UserAdapter(list, requireActivity())
                listView.adapter = adapter
            }
        }
    }
}