package io.github.vlodo_o.habit_tracker.ui.screens.habit_list

import io.github.vlodo_o.habit_tracker.domain.models.Habit

data class HabitListState(
    val currentDate: String = "",
    val habits: List<Habit> = emptyList(),
    val progress: Float = 0f,
    val isLoading: Boolean = false,
    val error: String? = null
)