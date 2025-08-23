package io.github.vlodo_o.habit_tracker.ui.screens.habit_settings

sealed class HabitSettingsEffect {
    object HabitSettingsSaved : HabitSettingsEffect()
    data class ShowError(val message: String) : HabitSettingsEffect()
}