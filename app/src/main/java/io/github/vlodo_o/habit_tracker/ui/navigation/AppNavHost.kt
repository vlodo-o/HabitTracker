package io.github.vlodo_o.habit_tracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import io.github.vlodo_o.habit_tracker.ui.screens.habit_list.HabitListScreen
import io.github.vlodo_o.habit_tracker.ui.screens.habit_settings.HabitSettingsScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "habit_list"
    ) {
        composable("habit_list") {
            HabitListScreen(
                onAddClick = { navController.navigate("habit_settings/-1L") },
                onHabitClick = { id -> navController.navigate("habit_settings/$id") }
            )
        }

        composable(
            route = "habit_settings/{habitId}",
            arguments = listOf(
                navArgument("habitId") {
                    type = NavType.LongType
                    nullable = false
                    defaultValue = -1L
                }
            )
        ) { backStackEntry ->
            val habitIdArg = backStackEntry.arguments?.getLong("habitId")
            val habitId = habitIdArg ?: -1L

            HabitSettingsScreen(
                habitId = habitId,
                onSaved = { navController.popBackStack() }
            )
        }
    }
}