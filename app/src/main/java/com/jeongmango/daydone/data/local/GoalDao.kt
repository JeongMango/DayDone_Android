package com.jeongmango.daydone.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface GoalDao {

    @Query("SELECT * FROM goals WHERE date = :date ORDER BY id")
    fun observeByDate(date: String): Flow<List<GoalEntity>>

    @Insert
    suspend fun insert(goal: GoalEntity)

    @Update
    suspend fun update(goal: GoalEntity)

    @Delete
    suspend fun delete(goal: GoalEntity)
}
