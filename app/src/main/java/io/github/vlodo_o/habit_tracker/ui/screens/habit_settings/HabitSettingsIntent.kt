package io.github.vlodo_o.habit_tracker.ui.screens.habit_settings

sealed class HabitSettingsIntent {
    data class OnNameChange(val name: String) : HabitSettingsIntent()
    object SaveHabit : HabitSettingsIntent()
}