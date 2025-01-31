package com.example.financialapp.databases.expenditureDatabase.userInfoDatabase

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserInfoDao {

    @Upsert
    fun insertUserInfo(userInfo: UserInfo)

    //DELETE
    @Query("DELETE FROM userInfo WHERE userName = :userName")
    fun deleteUserInfo(userName: String)

    //GET_ALL_ENTRIES
    @Query("SELECT * FROM userInfo ORDER BY userName ASC")
    fun getUserInfoByUsername(): List<UserInfo>

    @Query("SELECT * FROM userInfo ORDER BY userName ASC")
    fun getFlowByUsername(): Flow<List<UserInfo>>

    //CHECK_IF_USER_EXISTS
    @Query("SELECT EXISTS(SELECT * FROM userInfo WHERE userName = :userName)")
    fun isUserExist(userName: String) : Boolean

    //PULL_SINGLE_USER_DATA_USERNAME
    @Query("SELECT * FROM userInfo WHERE userName = :userName")
    fun getSingleUserData(userName: String) : UserInfo

    //PULL_SINGLE_USER_DATA_ID
    @Query("SELECT * FROM userInfo WHERE id = :userID")
    fun getUserData(userID: String) : UserInfo
}