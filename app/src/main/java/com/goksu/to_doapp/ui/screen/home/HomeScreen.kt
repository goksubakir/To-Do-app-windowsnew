package com.goksu.to_doapp.ui.screen.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.ui.tooling.preview.Preview
import com.goksu.to_doapp.ui.navigation.Route
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

// Görev veri modeli
data class Task(
    val title: String,
    val dueDate: LocalDate? = null,
    var isCompleted: Boolean = false,
    var isImportant: Boolean = false
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(onProfileClick: () -> Unit = {}, onRandomTextClick: () -> Unit) {
    var tasks = remember { mutableStateListOf<Task>() }
    var newTaskTitle by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF627EEA))
            .padding(16.dp)
    ) {
        Text(
            "Tasks",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Yeni görev ekleme alanı
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
                        tasks.add(Task(newTaskTitle, LocalDate.now()))
                        newTaskTitle = ""
                    }
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text("+ Add Task", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        val (completedTasks, pendingTasks) = tasks.partition { it.isCompleted }
        val (favoriteTasks, normalTasks) = pendingTasks.partition { it.isImportant }

        LazyColumn(modifier = Modifier.weight(1f)) {
            if (favoriteTasks.isNotEmpty()) {
                item {
                    Text("Favorites", fontSize = 20.sp, color = Color.Yellow, modifier = Modifier.padding(top = 16.dp))
                }
                items(favoriteTasks) { task ->
                    TaskItem(task, onTaskUpdate = { updatedTask ->
                        val index = tasks.indexOfFirst { it.title == task.title }
                        if (index != -1) tasks[index] = updatedTask
                    }, onDelete = { tasks.remove(task) })
                }
            }

            if (normalTasks.isNotEmpty()) {
                item {
                    Text("Tasks", fontSize = 20.sp, color = Color.White, modifier = Modifier.padding(top = 16.dp))
                }
                items(normalTasks) { task ->
                    TaskItem(task, onTaskUpdate = { updatedTask ->
                        val index = tasks.indexOfFirst { it.title == task.title }
                        if (index != -1) tasks[index] = updatedTask
                    }, onDelete = { tasks.remove(task) })
                }
            }

            if (completedTasks.isNotEmpty()) {
                item {
                    Text("Completed", fontSize = 20.sp, color = Color.White, modifier = Modifier.padding(top = 16.dp))
                }
                items(completedTasks) { task ->
                    TaskItem(task, completed = true, onTaskUpdate = { updatedTask ->
                        val index = tasks.indexOfFirst { it.title == task.title }
                        if (index != -1) tasks[index] = updatedTask
                    }, onDelete = { tasks.remove(task) })
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskItem(task: Task, completed: Boolean = false, onTaskUpdate: (Task) -> Unit, onDelete: () -> Unit) {
    var offsetX by remember { mutableStateOf(0f) }

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, dragAmount ->
                    offsetX += dragAmount
                    if (offsetX > 150) { // Sağ kaydırınca sil
                        onDelete()
                        offsetX = 0f
                    }
                }
            }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Tamamlama butonu
            IconButton(onClick = { onTaskUpdate(task.copy(isCompleted = !task.isCompleted)) }) {
                Icon(
                    imageVector = if (task.isCompleted) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle,
                    contentDescription = "Complete Task",
                    tint = if (task.isCompleted) Color.Gray else Color.Black
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = task.title,
                    fontSize = 18.sp,
                    textDecoration = if (task.isCompleted) TextDecoration.LineThrough else TextDecoration.None,
                    color = if (task.isCompleted) Color.Gray else Color.Black
                )
                task.dueDate?.let {
                    Text(
                        text = "\uD83D\uDCC5 ${it.format(DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH))}",
                        fontSize = 14.sp,
                        color = Color.Red
                    )
                }
            }

            // Önemli işaretleme butonu
            IconButton(onClick = { onTaskUpdate(task.copy(isImportant = !task.isImportant)) }) {
                Icon(
                    imageVector = if (task.isImportant) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = "Mark Important",
                    tint = if (task.isImportant) Color.Yellow else Color.Gray
                )
            }

            // Silme butonu (Sağa kaydırıldığında çıkacak)
            if (offsetX > 100) {
                IconButton(onClick = onDelete) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Delete Task",
                        tint = Color.Red
                    )
                }
            }
        }
    }
}
//TODO: Reminder ekle, saat ekle kum saati logosu koy bitenleri yesil yap.

//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    MaterialTheme {
//        HomeScreen(onRandomTextClick = {
//            navController.navigate(Route.RandomText.route)
//        })
//    }
//}
