package io.github.vlodo_o.habit_tracker.data

import io.github.vlodo_o.habit_tracker.data.db.AppDatabase
import io.github.vlodo_o.habit_tracker.data.db.toDomain
import io.github.vlodo_o.habit_tracker.data.db.toEntity
import io.github.vlodo_o.habit_tracker.domain.HabitRepository
import io.github.vlodo_o.habit_tracker.domain.models.Habit

class HabitRepositoryImpl(
    private val appDatabase: AppDatabase,
): HabitRepository {

    override suspend fun getHabitsList(): List<Habit> {
        val habitEntities = appDatabase.HabitDao().getAllHabits()
        return habitEntities.map { it.toDomain() }
    }

    override suspend fun getHabit(habitId: Long): Habit {
        val habitEntity = appDatabase.HabitDao().getHabit(habitId)
        return habitEntity.toDomain()
    }

    override suspend fun addHabit(habit: Habit) {
        appDatabase.HabitDao().insertHabit(habit.toEntity())
    }

    override suspend fun deleteHabit(habit: Habit) {
        appDatabase.HabitDao().deleteHabit(habit.toEntity())
    }

    override suspend fun updateHabit(habit: Habit) {
        appDatabase.HabitDao().updateHabit(habit.toEntity())
    }

}