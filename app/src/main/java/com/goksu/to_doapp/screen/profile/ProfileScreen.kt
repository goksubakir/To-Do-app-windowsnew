package com.goksu.to_doapp.screen.profile

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.goksu.to_doapp.R

@Composable
fun ProfileScreen(
    onBackClick: () -> Unit,
    uiState: ProfileUiState
) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image( //Bu kisma internetten baktim. (PNG olarak da yuklenebilir bakacagim ona muhtlaka :) )
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = uiState.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "user.email@example.com",
                color = Color.Gray
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Completed Tasks: ${uiState.completedTasks}", fontSize = 16.sp)
            Text(text = "Pending Tasks: ${uiState.pendingTasks}", fontSize = 16.sp)
            Text(text = "Total Tasks: ${uiState.totalTasks}", fontSize = 16.sp)
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {  }) {
                Text(text = "Edit Profile")
            }
            Button(onClick = { }) {
                Text(text = "Change Theme")
            }
            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(text = "Logout", color = Color.White)
            }
        }

        Button(onClick = onBackClick, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Back to Home")
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        ProfileScreen(
            onBackClick = {},
            uiState = ProfileUiState(
                name = "John Doe",
                completedTasks = 10,
                pendingTasks = 5,
                totalTasks = 15
            )
        )
    }
}