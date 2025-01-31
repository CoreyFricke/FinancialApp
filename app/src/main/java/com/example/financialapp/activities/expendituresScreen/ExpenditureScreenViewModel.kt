package com.example.financialapp.activities.expendituresScreen

import androidx.lifecycle.ViewModel
import com.example.financialapp.MainActivity
import com.example.financialapp.databases.expenditureDatabase.expendituresDatabase.ExpenditureData
import kotlin.math.roundToInt

class ExpenditureScreenViewModel : ViewModel() {

    fun getExpenditureSources() : List<ExpenditureData>{
        return MainActivity.expenditureSourceDatabase.dao.getExpenditureSourceByDescription(MainActivity.userID)
    }

    fun deleteExpenditureData(sourceID: Int){
        return MainActivity.expenditureSourceDatabase.dao.deleteExpenditureSource(sourceID)
    }

    fun calcTotalMonthlyExpenditure(): String{
        var total = 0.0
        val expenditureList = MainActivity.expenditureSourceDatabase.dao.getExpenditureSourceByDescription(MainActivity.userID)

        expenditureList.forEach { expenditure ->
            if(expenditure.expenditureType == "Weekly"){
                total += expenditure.amount.toDouble() * 4
            }
            else if(expenditure.expenditureType == "Monthly"){
                total += expenditure.amount.toDouble()
            }
            else{
                total += expenditure.amount.toDouble() / 12
            }
        }
        val roundedTotal = total.roundToInt()
        return roundedTotal.toString()
    }
}