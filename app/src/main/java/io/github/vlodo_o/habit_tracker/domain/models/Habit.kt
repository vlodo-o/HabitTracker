package io.github.vlodo_o.habit_tracker.domain.models

data class Habit(
    val id: Long = 0,
    val name: String,
    var isDone: Boolean = false
)