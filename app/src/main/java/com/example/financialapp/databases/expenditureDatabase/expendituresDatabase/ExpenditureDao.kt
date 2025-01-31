package com.example.financialapp.databases.expenditureDatabase.expendituresDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExpenditureDao {

    @Insert
    fun insertExpenditureSource(expenditureData: ExpenditureData)

    @Update
    fun updateExpenditureSource(expenditureData: ExpenditureData)

    //DELETE
    @Query("DELETE FROM expendituredata WHERE expenditureSourceID = :sourceID")
    fun deleteExpenditureSource(sourceID: Int)

    //DELETE - UserID
    @Query("DELETE FROM expendituredata WHERE userID = :userID")
    fun deleteExpenditureSourceOnUserID(userID: String)

    //GET_ALL_ENTRIES
    @Query("SELECT * FROM expendituredata WHERE userID = :userID ORDER BY description ASC")
    fun getExpenditureSourceByDescription(userID: String): List<ExpenditureData>
}