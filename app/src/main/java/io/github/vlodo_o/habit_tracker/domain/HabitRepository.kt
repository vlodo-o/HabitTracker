package io.github.vlodo_o.habit_tracker.domain

import io.github.vlodo_o.habit_tracker.domain.models.Habit
import kotlinx.coroutines.flow.Flow

interface HabitRepository {
    fun addHabit(habit: Habit)
    fun getAllHabits(): Flow<List<Habit>>
    fun deleteHabit()
    fun editHabit()
}