package io.github.vlodo_o.habit_tracker.domain.usecase

import io.github.vlodo_o.habit_tracker.domain.HabitRepository

class GetHabitUseCase(private val repository: HabitRepository) {
    suspend operator fun invoke(habitId: Long) = repository.getHabit(habitId)
}