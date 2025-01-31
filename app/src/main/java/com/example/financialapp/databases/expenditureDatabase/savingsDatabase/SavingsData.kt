package com.example.financialapp.databases.expenditureDatabase.savingsDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SavingsData(
    val userID: String,
    val description: String,
    val amountToSave: String,
    val percentageContribution: String,

    @PrimaryKey(autoGenerate = true)
    val savingsItemID: Int = 0
)
