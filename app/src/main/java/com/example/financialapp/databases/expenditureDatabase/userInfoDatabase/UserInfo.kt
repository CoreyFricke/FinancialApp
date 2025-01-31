package com.example.financialapp.databases.expenditureDatabase.userInfoDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserInfo(
    val userName: String,
    val password: String,
    val email: String,
    val age: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
