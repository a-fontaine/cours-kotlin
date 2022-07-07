package com.example.kotlinapp.DAO

import androidx.room.*
import com.example.kotlinapp.models.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("Select * from user")
    fun gelAllUsers(): List<User>

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)
}