package com.goksu.to_doapp.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileScreen(
    onBackClick: () -> Unit,
    uiState: ProfileUiState,
    onUsernameChange: (String) -> Unit
) {
    var isEditing by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf(uiState.username) }

    val progress = if (uiState.totalTasks > 0) {
        uiState.completedTasks.toFloat() / uiState.totalTasks.toFloat()
    } else 0f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // **Kullanıcı Adı ve Düzenleme Butonu**
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if (isEditing) {
                TextField(
                    value = username,
                    onValueChange = { username = it },
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = {
                    isEditing = false
                    onUsernameChange(username)
                }) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Save")
                }
            } else {
                Text(
                    text = "     Welcome, $username",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                    
                )
                IconButton(onClick = { isEditing = true }) {
                    Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit Name")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // **Tamamlanan, Devam Eden ve Toplam Görev Sayıları**
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ) {
            TaskInfoCard("Completed", uiState.completedTasks, Color.Green)
            TaskInfoCard("Pending", uiState.pendingTasks, Color.Yellow)
            TaskInfoCard("Total", uiState.totalTasks, Color.Blue)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // **Progress Bar**
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            Text(text = "Task Completion Progress", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))

            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(12.dp),
                color = Color.Green
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "%${(progress * 100).toInt()} Completed",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(550.dp))

        Button(onClick = onBackClick, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Back to Home")
        }
    }
}

// **Görev Sayılarını Gösteren Kutucuklar**
@Composable
fun TaskInfoCard(title: String, count: Int, color: Color) {
    Card(
        modifier = Modifier.size(100.dp, 80.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = count.toString(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
            Text(text = title, fontSize = 16.sp, color = Color.Gray)
        }
    }
}

// **Profil Ekranı Preview**
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        onBackClick = { },
        uiState = ProfileUiState(
            username = "Göksu",
            completedTasks = 10,
            pendingTasks = 5,
            totalTasks = 15
        ),
        onUsernameChange = {}
    )
}
