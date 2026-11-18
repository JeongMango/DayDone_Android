package com.jeongmango.daydone.di

import com.jeongmango.daydone.data.GoalRepository
import com.jeongmango.daydone.data.RoomGoalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindGoalRepository(impl: RoomGoalRepository): GoalRepository
}