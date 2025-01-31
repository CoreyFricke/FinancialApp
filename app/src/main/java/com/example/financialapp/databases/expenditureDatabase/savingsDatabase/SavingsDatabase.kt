package com.example.financialapp.databases.expenditureDatabase.savingsDatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [SavingsData::class],
    version = 1
)
abstract class SavingsDatabase: RoomDatabase() {
    abstract val dao: SavingsDao
}