package io.github.vlodo_o.habit_tracker.domain

import io.github.vlodo_o.habit_tracker.domain.models.Habit

interface HabitRepository {
    suspend fun getHabits(): List<Habit>
    suspend fun addHabit(habit: Habit)
    suspend fun updateHabit(habit: Habit)
    suspend fun deleteHabit(habit: Habit)
}