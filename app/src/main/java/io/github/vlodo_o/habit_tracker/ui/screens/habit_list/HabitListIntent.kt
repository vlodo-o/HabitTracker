package io.github.vlodo_o.habit_tracker.ui.screens.habit_list

import io.github.vlodo_o.habit_tracker.domain.models.Habit

sealed class HabitListIntent {
    object LoadHabits : HabitListIntent()
    data class ToggleHabit(val habit: Habit) : HabitListIntent()
    data class AddHabitClicked(val name: String) : HabitListIntent()
}