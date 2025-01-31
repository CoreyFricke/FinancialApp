package com.example.financialapp.databases.expenditureDatabase.incomeDatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [IncomeData::class],
    version = 1
)
abstract class IncomeDatabase: RoomDatabase() {
    abstract val dao: IncomeDao
}