package com.jeongmango.daydone.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jeongmango.daydone.data.Goal
import java.time.LocalDate

@Entity(tableName = "goals")
data class GoalEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: String,
    val title: String,
    val isDone: Boolean = false
)


fun GoalEntity.toGoal() = Goal(
    id = id,
    date = LocalDate.parse(date),
    title = title,
    isDone = isDone,
)

fun Goal.toEntity() = GoalEntity(
    id = id,
    date = date.toString(),
    title = title,
    isDone = isDone,
)