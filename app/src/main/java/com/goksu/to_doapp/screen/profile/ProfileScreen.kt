package com.goksu.to_doapp.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goksu.to_doapp.R

@Composable
fun ProfileScreen(
    onBackClick: () -> Unit,
    uiState: ProfileUiState
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                .fillMaxWidth()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_face_2_24),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(
                            brush = Brush.linearGradient(
                                listOf(Color.Cyan, Color.Blue)
                            )
                        ),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = uiState.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Kullanici",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            StatisticCard(
                title = "Completed",
                count = uiState.completedTasks,
                color = Color(0xFF4CAF50)
            )
            StatisticCard(
                title = "Pending",
                count = uiState.pendingTasks,
                color = Color(0xFFFFC107)
            )
            StatisticCard(title = "Total", count = uiState.totalTasks, color = Color(0xFF2196F3))
        }

        Text(
            text = "My Reports",
            modifier = Modifier.padding(vertical = 16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 1.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ReportCard(title = "Psychological Report") //TODO: Raporlar icin ayri bir ekran acilmali
            ReportCard(title = "Monthly Report") //TODO: Degerler Kullanicidan alinmali ve ona gore analizi yapilmali.
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ReportCard(title = "Daily Prediction") //TODO: Raporlar icin ayri bir ekran acilmali
            ReportCard(title = "Love Report") //TODO: Degerler Kullanicidan alinmali ve ona gore analizi yapilmali.
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { }) {
                Text(text = "Edit Profile")
            }
            Button(onClick = { }) {
                Text(text = "Change Theme")
            }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(text = "Logout", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBackClick, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Back to Home")
        }
    }
}

@Composable
fun StatisticCard(title: String, count: Int, color: Color) {
    Card(
        modifier = Modifier.size(87.dp),
        shape = RoundedCornerShape(20.dp),
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
                color = Color.White
            )
            Text(text = title, fontSize = 16.sp, color = Color.White)
        }
    }
}

@Composable
fun ReportCard(title: String) {
    Card(
        modifier = Modifier.size(150.dp, 80.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        ProfileScreen(
            onBackClick = { },
            uiState = ProfileUiState(
                name = "Goksu Bakir",
                completedTasks = 10,
                pendingTasks = 5,
                totalTasks = 15
            )
        )
    }
}