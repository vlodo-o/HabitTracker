package io.github.vlodo_o.habit_tracker.di

import io.github.vlodo_o.habit_tracker.ui.screens.habit_list.HabitListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HabitListViewModel(get(), get(), get())
    }
}
