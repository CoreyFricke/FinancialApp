package com.example.financialapp.Databases

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [UserInfo::class],
    version = 1
)
abstract class UserInfoDatabase: RoomDatabase() {
    abstract val dao: UserInfoDao
}