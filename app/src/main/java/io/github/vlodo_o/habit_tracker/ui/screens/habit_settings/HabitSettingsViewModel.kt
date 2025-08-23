package io.github.vlodo_o.habit_tracker.ui.screens.habit_settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.vlodo_o.habit_tracker.domain.models.Habit
import io.github.vlodo_o.habit_tracker.domain.usecase.CreateHabitUseCase
import io.github.vlodo_o.habit_tracker.domain.usecase.GetHabitUseCase
import io.github.vlodo_o.habit_tracker.domain.usecase.UpdateHabitUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HabitSettingsViewModel(
    private val habitId: Long,
    private val getHabitUseCase: GetHabitUseCase,
    private val createHabitUseCase: CreateHabitUseCase,
    private val updateHabitUseCase: UpdateHabitUseCase,
) : ViewModel(){
    private val _uiState = MutableStateFlow(HabitSettingsState(isLoading = true))
    val uiState: StateFlow<HabitSettingsState> = _uiState
    private val _effect = Channel<HabitSettingsEffect>()
    val effect = _effect.receiveAsFlow()
    var habit = Habit(name = "")
    init {
        viewModelScope.launch {
            if (habitId != -1L) {
                try {
                    habit = getHabitUseCase(habitId)
                    _uiState.update {
                        it.copy(
                            name = habit.name,
                            isLoading = false,
                            mode = HabitSettingsMode.EDIT
                        )
                    }
                } catch (e: Exception) {
                    _uiState.update { it.copy(isLoading = false) }
                    _effect.send(HabitSettingsEffect.ShowError("Ошибка загрузки привычки"))
                }
            } else {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

    fun handleIntent(intent: HabitSettingsIntent) {
        when(intent) {
            is HabitSettingsIntent.OnNameChange -> _uiState.update { it.copy(name = intent.name) }
            is HabitSettingsIntent.SaveHabit -> saveHabit()
        }
    }

    private fun saveHabit() {
        viewModelScope.launch {
            val currentState = _uiState.value
            if (currentState.name.isBlank()) {
                _effect.send(HabitSettingsEffect.ShowError("Название не может быть пустым"))
                return@launch
            }

            _uiState.update { it.copy(isLoading = true) }

            try {
                if (currentState.mode == HabitSettingsMode.CREATE) {
                    createHabitUseCase(currentState.name)
                } else {
                    updateHabitUseCase(habit.copy(name = currentState.name))
                }
                _effect.send(HabitSettingsEffect.HabitSettingsSaved)
            } catch (e: Exception) {
                _effect.send(HabitSettingsEffect.ShowError("Ошибка сохранения привычки"))
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

}