package com.jeongmango.daydone.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [GoalEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DayDoneDatabase : RoomDatabase() {
    abstract fun goalDao(): GoalDao
}