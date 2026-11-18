package com.jeongmango.daydone.data

import java.time.LocalDate

data class Goal (
    val id : Long,
    val date: LocalDate,
    val title: String,
    val isDone: Boolean
)