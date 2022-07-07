package com.example.kotlinapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlinapp.API.ApiClient
import com.example.kotlinapp.R
import com.example.kotlinapp.adapters.UserAdapter
import com.example.kotlinapp.models.User
import com.example.kotlinapp.repositories.UserRepository
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

        getListOfUser(v)

        return v
    }

    fun getListOfUser(v:View) {
        val userRepository = UserRepository(requireActivity())
        val allUsers = userRepository.getAllUsers() as MutableList

        if(allUsers.isNotEmpty()) {
            val listView = v.findViewById<ListView>(R.id.list_view)
            val adapter = UserAdapter(allUsers, requireActivity())
            listView.adapter = adapter

            Toast.makeText(activity, "Data found from db", Toast.LENGTH_LONG).show()
        } else {
            GlobalScope.launch(Dispatchers.Main) {
                val apiClient = ApiClient()
                val response = apiClient.apiService.getUsers()

                if(response.isSuccessful && response.body() != null){
                    val content = response.body()
                    val list = content as MutableList<User>

                    val listView = v.findViewById<ListView>(R.id.list_view)
                    val adapter = UserAdapter(list, requireActivity())
                    listView.adapter = adapter

                    userRepository.insertAllUserS(list)

                    Toast.makeText(activity, "Data found from API", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}