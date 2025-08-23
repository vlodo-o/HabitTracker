package io.github.vlodo_o.habit_tracker.ui.screens.habit_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.vlodo_o.habit_tracker.domain.habits.usecase.AddHabitUseCase
import io.github.vlodo_o.habit_tracker.domain.habits.usecase.GetHabitsUseCase
import io.github.vlodo_o.habit_tracker.domain.habits.usecase.ToggleHabitUseCase
import io.github.vlodo_o.habit_tracker.domain.models.Habit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HabitListViewModel(
    private val getHabitsUseCase: GetHabitsUseCase,
    private val toggleHabitUseCase: ToggleHabitUseCase,
    private val addHabitUseCase: AddHabitUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(HabitListState(isLoading = true))
    val uiState: StateFlow<HabitListState> = _uiState

    fun handleIntent(intent: HabitListIntent) {
        when (intent) {
            is HabitListIntent.LoadHabits -> loadHabits()
            is HabitListIntent.ToggleHabit -> toggleHabit(intent.habit)
            is HabitListIntent.AddHabitClicked -> addHabit(intent.name)
        }
    }

    private fun loadHabits() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val habits = getHabitsUseCase()
                val progress = if (habits.isNotEmpty()) {
                    habits.count { it.isDone }.toFloat() / habits.size
                } else 0f

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        habits = habits,
                        progress = progress,
                        currentDate = getCurrentDateString()
                    )
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    private fun toggleHabit(habit: Habit) {
        viewModelScope.launch {
            toggleHabitUseCase(habit)
            loadHabits()
        }
    }

    private fun addHabit(name: String) {
        viewModelScope.launch {
            addHabitUseCase(name)
            loadHabits()
        }
    }

    private fun getCurrentDateString(): String {
        val date = Date()
        val formatter = SimpleDateFormat("d MMMM", Locale.getDefault() )
        val formattedDate = formatter.format(date)
        return formattedDate
    }
}