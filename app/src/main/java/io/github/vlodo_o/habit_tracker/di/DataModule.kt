package io.github.vlodo_o.habit_tracker.di

import androidx.room.Room
import io.github.vlodo_o.habit_tracker.data.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "habit_tracker_database.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}