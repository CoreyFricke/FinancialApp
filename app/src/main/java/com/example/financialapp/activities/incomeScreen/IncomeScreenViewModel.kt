package com.example.financialapp.activities.incomeScreen

import androidx.lifecycle.ViewModel
import com.example.financialapp.MainActivity
import com.example.financialapp.databases.expenditureDatabase.incomeDatabase.IncomeData
import kotlin.math.roundToInt

class IncomeScreenViewModel : ViewModel() {

    fun getIncomeSources() : List<IncomeData>{
        return MainActivity.incomeSourceDatabase.dao.getIncomeSourceByDescription(MainActivity.userID)
    }

    fun deleteIncomeSource(incomeID: Int){
        MainActivity.incomeSourceDatabase.dao.deleteIncomeSource(incomeID)
    }

    fun calcAnnualIncome(): String{
        var total = 0.0
        val incomeList = MainActivity.incomeSourceDatabase.dao.getIncomeSourceByDescription(MainActivity.userID)

        incomeList.forEach { income ->
            if(income.salaryType == "Hourly Pay"){
                total += (income.hourlyIncome.toDouble() * income.hoursPerWeek.toDouble()) * 48.0
            }
            else{
                total += income.annualSalary.toDouble()
            }
        }
        val roundedTotal = total.roundToInt()
        return roundedTotal.toString()
    }
}