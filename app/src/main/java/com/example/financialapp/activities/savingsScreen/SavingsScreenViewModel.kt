package com.example.financialapp.activities.savingsScreen

import androidx.lifecycle.ViewModel
import com.example.financialapp.MainActivity
import com.example.financialapp.activities.expendituresScreen.ExpenditureScreenViewModel
import com.example.financialapp.activities.incomeScreen.IncomeScreenViewModel
import com.example.financialapp.databases.expenditureDatabase.savingsDatabase.SavingsData

class SavingsScreenViewModel : ViewModel() {
    private val incomeVM = IncomeScreenViewModel()
    private val expenditureVM = ExpenditureScreenViewModel()

    fun getSavingsList(): List<SavingsData>{
        return MainActivity.savingsDatabase.dao.getSavingsGoalByDescription(MainActivity.userID)
    }

    fun deleteSavingsGoal(savingsID: Int){
        MainActivity.savingsDatabase.dao.deleteSavingsGoal(savingsID)
   }

    fun calcRemainingfunds(): String{
        var totalMonthlyIncome = incomeVM.calcAnnualIncome().toInt() / 12
        var totalMonthlyExpenditures = expenditureVM.calcTotalMonthlyExpenditure().toInt()

        var savingsUsage = calSavingsUsage()

        return ((totalMonthlyIncome - totalMonthlyExpenditures) - savingsUsage).toString()
    }

    private fun calSavingsUsage(): Double{
        val savingsList = getSavingsList()
        var savingsTotal = 0.0

        savingsList.forEach { goal ->
            savingsTotal += goal.percentageContribution.toDouble()
        }

        return savingsTotal
    }
}