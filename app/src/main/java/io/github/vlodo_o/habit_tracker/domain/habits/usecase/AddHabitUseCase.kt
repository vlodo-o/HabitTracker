package io.github.vlodo_o.habit_tracker.domain.habits.usecase

import io.github.vlodo_o.habit_tracker.domain.HabitRepository
import io.github.vlodo_o.habit_tracker.domain.models.Habit

class AddHabitUseCase(private val repository: HabitRepository) {
    suspend operator fun invoke(name: String) {
        repository.addHabit(Habit(name = name))
    }
}