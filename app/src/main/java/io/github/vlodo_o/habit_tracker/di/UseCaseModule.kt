package io.github.vlodo_o.habit_tracker.di

import io.github.vlodo_o.habit_tracker.domain.habits.usecase.AddHabitUseCase
import io.github.vlodo_o.habit_tracker.domain.habits.usecase.GetHabitsUseCase
import io.github.vlodo_o.habit_tracker.domain.habits.usecase.ToggleHabitUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<GetHabitsUseCase> {
        GetHabitsUseCase(get())
    }
    single<AddHabitUseCase> {
        AddHabitUseCase(get())
    }
    single<ToggleHabitUseCase> {
        ToggleHabitUseCase(get())
    }
}