package com.goksu.to_doapp.screen.profile

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ProfileScreen(onBackClick: () -> Unit, uiState: ProfileUiState) {


    Column(
        modifier = Modifier.fillMaxSize(), // Sütunun tüm ekranı doldurmasını sağlar.
        horizontalAlignment = Alignment.CenterHorizontally, // Yatayda ortalanmasını sağlar.
        verticalArrangement = Arrangement.Center // Dikeyde ortalanmasını sağlar.
    ) {
        Text(text = "Profile Screen") // Ekranda "Profile Screen" yazan bir metin görüntüler.

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBackClick) {
            Text("Back to Home") // Düğmenin üzerinde "Back to Home" yazan bir metin görüntüler.
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview(){
    MaterialTheme {
        ProfileScreen(onBackClick = {}, uiState = ProfileUiState() )
    }
}




//+979 568 337 308