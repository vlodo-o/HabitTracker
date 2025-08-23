package io.github.vlodo_o.habit_tracker.data.db

import io.github.vlodo_o.habit_tracker.domain.models.Habit

fun Habit.toEntity(): HabitEntity {
    return HabitEntity(
        id = this.id,
        name = this.name,
        isDone = this.isDone
    )
}

fun HabitEntity.toDomain(): Habit {
    return Habit(
        id = this.id,
        name = this.name,
        isDone = this.isDone
    )
}