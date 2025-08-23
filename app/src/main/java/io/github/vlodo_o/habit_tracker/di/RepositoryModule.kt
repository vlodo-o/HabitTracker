package io.github.vlodo_o.habit_tracker.di

import io.github.vlodo_o.habit_tracker.data.HabitRepositoryImpl
import io.github.vlodo_o.habit_tracker.domain.HabitRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HabitRepository> {
        HabitRepositoryImpl(get())
    }
}