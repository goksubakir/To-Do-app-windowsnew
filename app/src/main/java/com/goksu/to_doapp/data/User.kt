package com.goksu.to_doapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userid: Int = 0,
    val username: String,
    val fullname: String,
    val email: String,
    val password: String
)
