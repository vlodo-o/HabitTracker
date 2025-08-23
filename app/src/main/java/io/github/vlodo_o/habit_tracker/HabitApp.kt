package io.github.vlodo_o.habit_tracker

import android.app.Application
import io.github.vlodo_o.habit_tracker.di.dataModule
import io.github.vlodo_o.habit_tracker.di.repositoryModule
import io.github.vlodo_o.habit_tracker.di.useCaseModule
import io.github.vlodo_o.habit_tracker.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class HabitApp: Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidContext(this@HabitApp)
            modules(dataModule, repositoryModule, useCaseModule, viewModelModule)
        }
    }
}