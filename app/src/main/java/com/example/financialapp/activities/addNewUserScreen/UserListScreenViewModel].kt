package com.example.financialapp.activities.addNewUserScreen

import androidx.lifecycle.ViewModel
import com.example.financialapp.MainActivity
import com.example.financialapp.databases.expenditureDatabase.userInfoDatabase.UserInfo

class UserListScreenViewModel : ViewModel(){

    fun getUserList(): List<UserInfo> {
        return MainActivity.userInfoDatabase.dao.getUserInfoByUsername()
    }

    //TODO - Get flow working for real-time lists
    suspend fun getFlow() : List<UserInfo> {
        lateinit var testList: List<UserInfo>
        var flow = MainActivity.userInfoDatabase.dao.getFlowByUsername()

        flow.collect { flowList ->
            testList = flowList
        }
        return testList
    }

    //Delete user and all database entries with the same user ID
    fun deleteUser(userName: String, userID: String){
        MainActivity.userInfoDatabase.dao.deleteUserInfo(userName)
        MainActivity.incomeSourceDatabase.dao.deleteIncomeSourceByUserID(userID)
        MainActivity.expenditureSourceDatabase.dao.deleteExpenditureSourceOnUserID(userID)
        MainActivity.savingsDatabase.dao.deleteSavingsGoalByUserID(userID)
    }
}