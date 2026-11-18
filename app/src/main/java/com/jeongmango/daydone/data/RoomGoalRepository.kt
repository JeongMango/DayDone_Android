package com.jeongmango.daydone.data

import com.jeongmango.daydone.data.local.GoalDao
import com.jeongmango.daydone.data.local.GoalEntity
import com.jeongmango.daydone.data.local.toEntity
import com.jeongmango.daydone.data.local.toGoal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import javax.inject.Inject

class RoomGoalRepository @Inject constructor(
    private val dao: GoalDao,
) : GoalRepository {

    override fun observeGoals(date: LocalDate): Flow<List<Goal>> =
        dao.observeByDate(date.toString()).map { entities ->
            entities.map { it.toGoal() }
        }

    override suspend fun addGoal(date: LocalDate, title: String) {
        dao.insert(GoalEntity(date = date.toString(), title = title))
    }

    override suspend fun toggleGoal(goal: Goal) {
        dao.update(goal.copy(isDone = !goal.isDone).toEntity())
    }

    override suspend fun deleteGoal(goal: Goal) {
        dao.delete(goal.toEntity())
    }

}