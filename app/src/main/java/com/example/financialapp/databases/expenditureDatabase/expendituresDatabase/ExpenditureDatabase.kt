package com.example.financialapp.databases.expenditureDatabase.expendituresDatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ExpenditureData::class],
    version = 1
)
abstract class ExpenditureDatabase: RoomDatabase() {
    abstract val dao: ExpenditureDao
}