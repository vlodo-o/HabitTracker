package io.github.vlodo_o.habit_tracker.ui.screens.habit_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.vlodo_o.habit_tracker.domain.models.Habit
import io.github.vlodo_o.habit_tracker.ui.theme.HabitTrackerTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitListScreen() {

    var habits by remember {
        mutableStateOf(
            listOf(
                Habit("Привычка 1"),
                Habit("Привычка 2"),
                Habit("Привычка 3"),
                Habit("Привычка 4"),
                Habit("Привычка 5"),
                Habit("Привычка 6")
            )
        )
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Трекер Привычек") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            val date = Date()
            val formatter = SimpleDateFormat("d MMMM", Locale("ru"))
            val formattedDate = formatter.format(date)
            Text(
                text = formattedDate,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp).align(Alignment.CenterHorizontally)
            )

            val progress = habits.count { it.done }.toFloat() / habits.size
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .padding(bottom = 16.dp)
            )
            Text("${(progress * 100).toInt()}% выполнено", fontSize = 12.sp)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(habits) { habit ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Checkbox(
                            checked = habit.done,
                            onCheckedChange = { isChecked ->
                                habits = habits.map {
                                    if (it.name == habit.name) it.copy(done = isChecked) else it
                                }
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(habit.name, modifier = Modifier.weight(1f))
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {  },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("+ Добавить привычку")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HabitListPreview() {
    HabitTrackerTheme {
        HabitListScreen()
    }
}