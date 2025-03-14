package com.goksu.to_doapp.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ProfileScreen(
    onBackClick: () -> Unit,
    onLogout: () -> Unit,
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
        if (isEditing) {
            TextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            IconButton(onClick = {
                isEditing = false
                onUsernameChange(username)
            }) {
                Icon(imageVector = Icons.Filled.Check, contentDescription = "Save")
            }
        } else {
            Text(
                text = username,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            IconButton(onClick = { isEditing = true }) {
                Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit Name")
            }
        }

        Text(text = uiState.location, fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TaskInfoCard("Completed", uiState.completedTasks, Color.Green)
            TaskInfoCard("Pending", uiState.pendingTasks, Color.Yellow)
            TaskInfoCard("Total", uiState.totalTasks, Color.Blue)
        }

        Spacer(modifier = Modifier.height(16.dp))

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

        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            ProfileOption(icon = Icons.Filled.Settings, text = "Settings")
            ProfileOption(icon = Icons.Filled.Star, text = "Favorites")
            ProfileOption(icon = Icons.Filled.ShoppingCart, text = "Premium Membership")
            ProfileOption(icon = Icons.Filled.ExitToApp, text = "Logout", isDestructive = true, onClick = onLogout)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBackClick, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Back to Home")
        }
    }
}

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

@Composable
fun ProfileOption(icon: ImageVector, text: String, isDestructive: Boolean = false, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(if (isDestructive) Color.Red.copy(alpha = 0.1f) else Color.Transparent)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = text, tint = if (isDestructive) Color.Red else Color.Black)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontSize = 18.sp, fontWeight = FontWeight.Medium, color = if (isDestructive) Color.Red else Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        onBackClick = { },
        onLogout = {},
        uiState = ProfileUiState(
            username = "Göksu",
            completedTasks = 10,
            pendingTasks = 5,
            totalTasks = 15,
            location = "Istanbul, Turkey"
        ),
        onUsernameChange = {}
    )
}
