package com.example.financialapp.activities.incomeScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.financialapp.MainActivity
import com.example.financialapp.databases.expenditureDatabase.incomeDatabase.IncomeData

class NewIncomeSourceViewModel: ViewModel() {
    //DropDown
    var isExpanded by mutableStateOf(false)
    //TODO - Change salary options to Enum
    val dropDownOptions = listOf("Hourly Pay", "Salary Pay", "Misc")
    private var selectedText by mutableStateOf(dropDownOptions[0])

    //Income Database
    private var description by mutableStateOf("")
    private var hourlyIncome by mutableStateOf("0")
    private var hoursPerWeek by mutableStateOf("0")
    private var totalPayCheckDeductibles by mutableStateOf("0")
    private var annualSalary by mutableStateOf("0")

    fun addIncomeSource(): String{
        if(validateUserInputs()){
            if(selectedText == dropDownOptions[0]){
                addHourlyPay()
            }
            else if(selectedText == dropDownOptions[1]){
                addSalaryPay()
            }
            else{
                addMiscPay()
            }
            return "Income Saved!"
        }
        else{
            return "Invalid Values"
        }
    }

    private fun validateUserInputs(): Boolean{
        if(
            isValidDouble(hourlyIncome)
            && isValidDouble(hoursPerWeek)
            && isValidDouble(totalPayCheckDeductibles)
            && isValidDouble(annualSalary)
                ){
            return true
        }
        else{
            return false
        }
    }

    private fun isValidDouble(num: String): Boolean{
        return num.toDoubleOrNull() != null
    }

    private fun addHourlyPay(){
        MainActivity.incomeSourceDatabase.dao.insertIncomeSource(
            IncomeData(
                MainActivity.userID,
                description,
                hourlyIncome,
                hoursPerWeek,
                totalPayCheckDeductibles,
                "",
                selectedText
            )
        )
    }
    private fun addSalaryPay(){
        MainActivity.incomeSourceDatabase.dao.insertIncomeSource(
            IncomeData(
                MainActivity.userID,
                description,
                "",
                "",
                "",
                annualSalary,
                selectedText
            )
        )
    }
    private fun addMiscPay(){
        MainActivity.incomeSourceDatabase.dao.insertIncomeSource(
            IncomeData(
                MainActivity.userID,
                description,
                "",
                "",
                "",
                annualSalary,
                selectedText
            )
        )
    }

    //Getters
    fun getterDescription():String{
        return description
    }
    fun getterHourlyIncome():String{
        return hourlyIncome
    }
    fun getterHoursPerWeek():String{
        return hoursPerWeek
    }
    fun getterPaycheckDeductibles():String{
        return totalPayCheckDeductibles
    }
    fun getterAnnualSalary():String{
        return annualSalary
    }
    fun getterSelectedText():String{
        return selectedText
    }
    //Setter
    fun setterDescription(input: String){
        description = input
    }
    fun setterHourlyIncome(input: String){
        hourlyIncome = input
    }
    fun setterHoursPerWeek(input: String){
        hoursPerWeek = input
    }
    fun setterPaycheckDeductibles(input: String){
        totalPayCheckDeductibles = input
    }
    fun setterAnnualSalary(input: String){
        annualSalary = input
    }
    fun setterSelectedText(input: String){
        selectedText = input
    }
}