package io.github.vlodo_o.habit_tracker.domain.models

data class Habit(
    val name: String,
    var done: Boolean = false
)