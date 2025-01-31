package com.example.financialapp.databases.expenditureDatabase.savingsDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SavingsDao {
    @Insert
    fun insertSavingsGoal(savingsData: SavingsData)

    @Update
    fun updateSavingsGoal(savingsData: SavingsData)

    //DELETE
    @Query("DELETE FROM savingsdata WHERE savingsItemID = :savingsID")
    fun deleteSavingsGoal(savingsID: Int)

    //DELETE - userID
    @Query("DELETE FROM savingsdata WHERE userID = :userID")
    fun deleteSavingsGoalByUserID(userID: String)

    //GET_ALL_ENTRIES
    @Query("SELECT * FROM savingsdata WHERE userID = :userID ORDER BY description ASC")
    fun getSavingsGoalByDescription(userID: String): List<SavingsData>
}