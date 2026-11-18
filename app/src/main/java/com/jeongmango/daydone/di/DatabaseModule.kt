package com.jeongmango.daydone.di

import android.content.Context
import androidx.room.Room
import com.jeongmango.daydone.data.local.DayDoneDatabase
import com.jeongmango.daydone.data.local.GoalDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DayDoneDatabase =
        Room.databaseBuilder(context, DayDoneDatabase::class.java, "daydone.db").build()

    @Provides
    fun provideGoalDao(database: DayDoneDatabase): GoalDao = database.goalDao()
}