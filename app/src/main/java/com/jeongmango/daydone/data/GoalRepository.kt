package com.jeongmango.daydone.data

import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface GoalRepository {
    fun observeGoals(date: LocalDate): Flow<List<Goal>>
    suspend fun addGoal(date: LocalDate, title: String)
    suspend fun toggleGoal(goal: Goal)
    suspend fun deleteGoal(goal: Goal)
}