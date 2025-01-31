package com.example.financialapp.databases.expenditureDatabase.incomeDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class IncomeData(
    val userID: String,
    val description: String,
    val hourlyIncome: String,
    val hoursPerWeek: String,
    val totalPaycheckDeductibles: String,
    val annualSalary: String,
    val salaryType: String,

    @PrimaryKey(autoGenerate = true)
    val incomeSourceID: Int = 0
)