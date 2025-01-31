package com.example.financialapp.activities.savingsScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.financialapp.MainActivity
import com.example.financialapp.activities.expendituresScreen.ExpenditureScreenViewModel
import com.example.financialapp.activities.incomeScreen.IncomeScreenViewModel
import com.example.financialapp.databases.expenditureDatabase.savingsDatabase.SavingsData

class NewSavingsViewModel : ViewModel() {
    private val incomeVM = IncomeScreenViewModel()
    private val expenditureVM = ExpenditureScreenViewModel()
    //DropDown
    var isExpanded by mutableStateOf(false)
    val dropDownOptions = listOf("Weekly", "Monthly", "Yearly")
    var selectedText by mutableStateOf(dropDownOptions[0])

    var description by mutableStateOf("")
    var amount by mutableStateOf("")
    var percentageContribution by mutableStateOf("")

    fun addSavingsGoal(){
        MainActivity.savingsDatabase.dao.insertSavingsGoal(
            SavingsData(
                MainActivity.userID,
                description,
                amount,
                percentageContribution
            )
        )
    }

    private fun getSavingsList(): List<SavingsData>{
        return MainActivity.savingsDatabase.dao.getSavingsGoalByDescription(MainActivity.userID)
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