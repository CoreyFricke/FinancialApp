package com.example.financialapp.activities.expendituresScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.financialapp.MainActivity
import com.example.financialapp.databases.expenditureDatabase.expendituresDatabase.ExpenditureData

class NewExpenditureViewModel: ViewModel() {
    //DropDown
    var isExpanded by mutableStateOf(false)
    val dropDownOptions = listOf("Weekly", "Monthly", "Yearly")
    var selectedText by mutableStateOf(dropDownOptions[0])

    var description by mutableStateOf("")
    var amount by mutableStateOf("")

    fun addExpenditureSource(){
        if(isValidDouble(amount)){
            MainActivity.expenditureSourceDatabase.dao.insertExpenditureSource(
                ExpenditureData(
                    MainActivity.userID,
                    description,
                    selectedText,
                    amount
                )
            )
        }
    }

    private fun isValidDouble(num: String): Boolean{
        return num.toDoubleOrNull() != null
    }
}