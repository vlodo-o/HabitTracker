package io.github.vlodo_o.habit_tracker.ui.screens.habit_settings


data class HabitSettingsState (
    val name: String = "",
    val isLoading: Boolean = false,
    val mode: HabitSettingsMode = HabitSettingsMode.CREATE
)