package com.example.kotlinapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@PrimaryKey val id :Int,
                val name :String,
                val username :String,
                val email :String,
                val phone :String,
                val website :String,
                val lat : Double,
                val lng : Double) {

}