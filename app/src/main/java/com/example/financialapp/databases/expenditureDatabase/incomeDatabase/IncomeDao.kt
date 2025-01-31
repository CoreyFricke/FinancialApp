package com.example.financialapp.databases.expenditureDatabase.incomeDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface IncomeDao {

    @Insert
    fun insertIncomeSource(incomeData: IncomeData)

    @Update
    fun updateIncomeSource(incomeData: IncomeData)

    //DELETE
    @Query("DELETE FROM incomedata WHERE incomeSourceID = :incomeID")
    fun deleteIncomeSource(incomeID: Int)

    //DELETE - UserID
    @Query("DELETE FROM incomedata WHERE userID = :userID")
    fun deleteIncomeSourceByUserID(userID: String)

    //GET_ALL_ENTRIES
    @Query("SELECT * FROM incomeData WHERE userID = :userID ORDER BY description ASC")
    fun getIncomeSourceByDescription(userID: String): List<IncomeData>
}