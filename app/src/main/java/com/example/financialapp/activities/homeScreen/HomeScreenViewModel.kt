package com.example.financialapp.activities.homeScreen

import androidx.lifecycle.ViewModel
import com.example.financialapp.MainActivity
import com.example.financialapp.activities.savingsScreen.SavingsScreenViewModel
import com.example.financialapp.databases.expenditureDatabase.userInfoDatabase.UserInfo
import kotlin.math.roundToInt

class HomeScreenViewModel : ViewModel(){
    private val savingsVM = SavingsScreenViewModel()

    fun getUser(userID: String) : UserInfo {
        return MainActivity.userInfoDatabase.dao.getUserData(userID)
    }

    fun calcAnnualIncome(): List<String>{
        var annualSalary = 0.0
        var monthlylIncome = 0
        var numSources = 0

        val incomeList = MainActivity.incomeSourceDatabase.dao.getIncomeSourceByDescription(MainActivity.userID)

        incomeList.forEach { incomeSource ->
            if(incomeSource.salaryType == "Hourly Pay"){
                annualSalary += (incomeSource.hourlyIncome.toDouble() * incomeSource.hoursPerWeek.toDouble()) * 48.0
            }
            else{
                annualSalary += incomeSource.annualSalary.toDouble()
            }
            numSources++
        }
        val roundedTotal = annualSalary.roundToInt()
        monthlylIncome = roundedTotal/12
        return listOf(numSources.toString(), roundedTotal.toString(), monthlylIncome.toString())
    }

    fun calExpenditures(): List<String>{
        var numExpenditures = 0.0
        var totalMonthly = 0.0

        val expenditureList = MainActivity.expenditureSourceDatabase.dao.getExpenditureSourceByDescription(MainActivity.userID)

        expenditureList.forEach { expenditure ->
            if (expenditure.expenditureType == "Weekly") {
                totalMonthly += expenditure.amount.toDouble() * 4
            } else if (expenditure.expenditureType == "Monthly") {
                totalMonthly += expenditure.amount.toDouble()
            } else {
                totalMonthly += expenditure.amount.toDouble() / 12
            }
            numExpenditures++
        }

        return listOf(numExpenditures.toString(), totalMonthly.toString())
    }

    fun calSavings(): List<String>{
        var numSavings = 0
        var remainingFunds = savingsVM.calcRemainingfunds()

        val savingsList = MainActivity.savingsDatabase.dao.getSavingsGoalByDescription(MainActivity.userID)

        savingsList.forEach { goal ->
            numSavings++
        }

        return listOf(numSavings.toString(), remainingFunds.toString())
    }

}