package com.example.financialapp.activities.loginScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.financialapp.MainActivity
import com.example.financialapp.databases.expenditureDatabase.userInfoDatabase.UserInfo

class LoginScreenViewModel: ViewModel() {
    //User info
    private var userName by mutableStateOf("")
    private var userPassword by mutableStateOf("")
    //Permission to enter next screen
    private var userAccessGranted by mutableStateOf(false)

    private val userTommy = UserInfo(
        "Tommy",
        "Tommy1zC00l27",
        "tommyTompson@gsnail.com",
        26
    )

    private val userRachel = UserInfo(
        "Rachel",
        "P0ssum\$RN33t34",
        "rachelyularen@gsnail.com",
        35
    )

    //Checks that the entered credentials exists and validates
    //Returns a string that is displayed in a toast message
    fun loginUser(userName: String) : String{
        if(MainActivity.userInfoDatabase.dao.isUserExist(userName)){
            val userInfo = getUserInfo(userName)

            if(userPassword == userInfo.password){
                userAccessGranted = true
                MainActivity.userID = userInfo.id.toString()
                return "Login Successful"
            }
            else{
                return "Incorrect Password"
            }
        }
        else{
            Log.d("TestLog", "Entry Does Not Exist")
            return "Username Not Found - Create New Account"
        }
    }

    //Checks if exists then loads
    fun loadPreMade1(){
        if(MainActivity.userInfoDatabase.dao.isUserExist("Tommy")){
            val userInfo = MainActivity.userInfoDatabase.dao.getSingleUserData("Tommy")
            setUsername(userInfo.userName)
            setPassword(userInfo.password)
        }
        else{
            MainActivity.userInfoDatabase.dao.insertUserInfo(userTommy)
        }

    }
    fun loadPreMade2(){
        if(MainActivity.userInfoDatabase.dao.isUserExist("Rachel")){
            val userInfo = MainActivity.userInfoDatabase.dao.getSingleUserData("Rachel")
            setUsername(userInfo.userName)
            setPassword(userInfo.password)
        }
        else{
            MainActivity.userInfoDatabase.dao.insertUserInfo(userRachel)
        }

    }

    private fun getUserInfo(userName: String) : UserInfo {
        return MainActivity.userInfoDatabase.dao.getSingleUserData(userName)
    }

    //Getters
    fun getUsername(): String{
        return userName
    }
    fun getPassword(): String{
        return userPassword
    }
    fun getAccessGranted(): Boolean{
        return userAccessGranted
    }

    //Setters
    fun setUsername(input: String){
        userName = input
    }
    fun setPassword(input: String){
        userPassword = input
    }
    fun setAccessGranted(input: Boolean){
        userAccessGranted = input
    }
}