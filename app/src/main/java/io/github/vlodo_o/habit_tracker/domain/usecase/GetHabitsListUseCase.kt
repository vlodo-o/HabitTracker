package io.github.vlodo_o.habit_tracker.domain.usecase

import io.github.vlodo_o.habit_tracker.domain.HabitRepository
import io.github.vlodo_o.habit_tracker.domain.models.Habit

class GetHabitsListUseCase(private val repository: HabitRepository) {
    suspend operator fun invoke(): List<Habit> = repository.getHabitsList()
}