package com.example.kotlinapp.models

data class User(val id :Int,
           val name :String,
           val username :String,
           val email :String,
           val phone :String,
           val website :String,
           val lat : Double,
           val lng : Double) {

}