package com.example.financialapp.activities.addNewUserScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.financialapp.MainActivity
import com.example.financialapp.databases.expenditureDatabase.userInfoDatabase.UserInfo

class NewUserScreenViewModel : ViewModel() {
    private var userName by mutableStateOf("")
    private var userPassword by mutableStateOf("")
    private var userEmail by mutableStateOf("")
    private var userAge by mutableStateOf("0")

    fun checkUserExist(): String{
        if(MainActivity.userInfoDatabase.dao.isUserExist(userName) || userName == "" || userPassword == ""){
            return "Error - User Exists or Username/Password Left Blank"
        }
        else{
            if(isValidInt(userAge)){
                saveNewUser()
                return "Successfully Saved!"
            }
            else{
                return "Change Age to valid number"
            }
        }
    }

    private fun isValidInt(num: String): Boolean{
        return num.toIntOrNull() != null
    }

    private fun saveNewUser(){
        MainActivity.userInfoDatabase.dao.insertUserInfo(
            UserInfo(
                userName,
                userPassword,
                userEmail,
                userAge.toInt()
            )
        )
    }

    //TODO - Traditional naming convention conflicting with Android Studio libraries?
    //Getters
    fun myUserNameGetter(): String{
        return userName
    }
    fun myUserPasswordGetter(): String{
        return userPassword
    }
    fun myUserEmailGetter(): String{
        return userEmail
    }
    fun myUserAgeGetter(): String{
        return userAge
    }

    //Setters
    fun myUserNameSetter(input: String){
        userName = input
    }
    fun myUserUserPasswordSetter(input: String){
        userPassword = input
    }
    fun myUserEmailSetter(input: String){
        userEmail = input
    }
    fun myUserAgeSetter(input: String){
        userAge = input
    }
}