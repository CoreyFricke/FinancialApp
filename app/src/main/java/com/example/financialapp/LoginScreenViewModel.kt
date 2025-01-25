package com.example.financialapp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginScreenViewModel: ViewModel() {

    var number by mutableIntStateOf(0)
    var userInput by mutableStateOf("")

    fun addOne(){
        number++
    }

    fun multiplyByTwo() : Int{
        return number * 2
    }

    fun deleteUser(userName: String){
        MainActivity.database.dao.deleteUserInfo(userName)
    }

    fun checkUserExists(userName: String) : String{
        if(MainActivity.database.dao.isUserExist(userName)){
            Log.d("TestLog", "Entry Exists")
            return "Entry Exists"
        }
        else{
            Log.d("TestLog", "Entry Does Not Exist")
            return "Entry Does Not Exist"
        }
    }
}