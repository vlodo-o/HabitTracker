package io.github.vlodo_o.habit_tracker.domain.usecase

import io.github.vlodo_o.habit_tracker.domain.HabitRepository
import io.github.vlodo_o.habit_tracker.domain.models.Habit

class ToggleHabitUseCase(private val repository: HabitRepository) {
    suspend operator fun invoke(habit: Habit) {
        repository.updateHabit(habit)
    }
}