package com.goksu.to_doapp.ui.screen.home

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
data class Task(
    val id: Int,
    val title: String,
    var isCompleted: Boolean = false,
    var isImportant: Boolean = false,
    var dueDateTime: LocalDateTime = LocalDateTime.now()
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    onProfileClick: (Int, Int, Int) -> Unit = { _, _, _ -> },
    onRandomTextClick: () -> Unit = {}
) {
    var tasks = remember { mutableStateListOf<Task>() }
    var newTaskTitle by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF627EEA))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Tasks",
                fontSize = 30.sp,
                color = Color.White
            )
            IconButton(onClick = {
                val completedTasks = tasks.count { it.isCompleted }
                val totalTasks = tasks.size
                val pendingTasks = totalTasks - completedTasks
                onProfileClick(completedTasks, pendingTasks, totalTasks)
            }) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = newTaskTitle,
                onValueChange = { newTaskTitle = it },
                placeholder = { Text("Yeni görev ekleyin...") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    if (newTaskTitle.isNotEmpty()) {
                        tasks.add(Task(id = tasks.size, title = newTaskTitle))
                        newTaskTitle = ""
                    }
                }
            ) {
                Text("+ Add Task")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(tasks) { task ->
                TaskItem(
                    task = task,
                    onTaskUpdate = { updatedTask ->
                        val index = tasks.indexOfFirst { it.id == task.id }
                        if (index != -1) tasks[index] = updatedTask
                    },
                    onDelete = { deletedTask ->
                        tasks.remove(deletedTask)
                    }
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskItem(
    task: Task,
    onTaskUpdate: (Task) -> Unit,
    onDelete: (Task) -> Unit
) {
    val context = LocalContext.current
    val formattedDate = task.dueDateTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm"))

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = { isChecked ->
                    onTaskUpdate(task.copy(isCompleted = isChecked))
                }
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = task.title,
                    fontSize = 18.sp,
                    color = if (task.isCompleted) Color.Gray else Color.Black
                )
                Text(
                    text = "\uD83D\uDCC5 $formattedDate",
                    fontSize = 14.sp,
                    color = Color.Red,
                    modifier = Modifier.clickable {
                        val calendar = Calendar.getInstance()
                        val datePicker = DatePickerDialog(
                            context,
                            { _, year, month, dayOfMonth ->
                                val timePicker = TimePickerDialog(
                                    context,
                                    { _, hour, minute ->
                                        val newDateTime = LocalDateTime.of(year, month + 1, dayOfMonth, hour, minute)
                                        onTaskUpdate(task.copy(dueDateTime = newDateTime))
                                    },
                                    calendar.get(Calendar.HOUR_OF_DAY),
                                    calendar.get(Calendar.MINUTE),
                                    true
                                )
                                timePicker.show()
                            },
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH)
                        )
                        datePicker.show()
                    }
                )
            }

            IconButton(onClick = { onDelete(task) }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete Task",
                    tint = Color.Red
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
