package io.github.vlodo_o.habit_tracker.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.vlodo_o.habit_tracker.ui.screens.habit_list.HabitListScreen
import io.github.vlodo_o.habit_tracker.ui.theme.HabitTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitTrackerTheme {
                HabitListScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainPreview() {
    HabitTrackerTheme {
        HabitListScreen()
    }
}