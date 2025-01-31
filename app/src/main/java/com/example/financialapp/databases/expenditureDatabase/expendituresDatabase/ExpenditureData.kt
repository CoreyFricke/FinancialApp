package com.example.financialapp.databases.expenditureDatabase.expendituresDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExpenditureData(
    val userID: String,
    val description: String,
    val expenditureType: String,
    val amount: String,

    @PrimaryKey(autoGenerate = true)
    val expenditureSourceID: Int = 0
)