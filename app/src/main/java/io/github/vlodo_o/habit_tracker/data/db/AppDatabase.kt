package io.github.vlodo_o.habit_tracker.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [HabitEntity::class],
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun HabitDao(): HabitDao
}