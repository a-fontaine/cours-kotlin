package com.example.kotlinapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kotlinapp.R
import com.example.kotlinapp.models.User

class UserAdapter(val users:MutableList<User>, val context:Context) :BaseAdapter() {
    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(p0: Int): Any {
        return users[p0]
    }

    override fun getItemId(p0: Int): Long {
        return users[p0].id.toLong()
    }

    override fun getView(p0: Int, convertView: View?, viewGroup: ViewGroup?): View? {
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, viewGroup, false)
        }

        val textView1 = convertView?.findViewById<TextView>(R.id.text_view1)
        val textView2 = convertView?.findViewById<TextView>(R.id.text_view2)

        var item = getItem(p0) as User
        textView1?.text = item.username
        textView2?.text = item.website

        return convertView
    }

}