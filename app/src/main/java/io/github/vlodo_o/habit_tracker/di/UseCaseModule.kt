package io.github.vlodo_o.habit_tracker.di

import io.github.vlodo_o.habit_tracker.domain.usecase.CreateHabitUseCase
import io.github.vlodo_o.habit_tracker.domain.usecase.GetHabitUseCase
import io.github.vlodo_o.habit_tracker.domain.usecase.GetHabitsListUseCase
import io.github.vlodo_o.habit_tracker.domain.usecase.ToggleHabitUseCase
import io.github.vlodo_o.habit_tracker.domain.usecase.UpdateHabitUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<GetHabitsListUseCase> {
        GetHabitsListUseCase(get())
    }
    single<CreateHabitUseCase> {
        CreateHabitUseCase(get())
    }
    single<ToggleHabitUseCase> {
        ToggleHabitUseCase(get())
    }
    single<UpdateHabitUseCase> {
        UpdateHabitUseCase(get())
    }
    single<GetHabitUseCase> {
        GetHabitUseCase(get())
    }
}