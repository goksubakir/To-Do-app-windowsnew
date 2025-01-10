package com.goksu.to_doapp.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import kotlinx.coroutines.delay

// SplashScreen adlı bir Composable fonksiyon tanımlıyoruz.
// Bu fonksiyon, uygulama açıldığında görülen giriş ekranını temsil eder.
// `onSplashComplete` callback'i, Splash ekranının tamamlandığını bildirmek için çağrılır.
@Composable
fun SplashScreen(onSplashComplete: () -> Unit, uiState: SplashUiState) {

    // LaunchedEffect bir yan etki (side effect) işlemi tanımlamak için kullanılır.
    // `Unit` parametresi, bu yan etkinin sadece bir kez çalıştırılmasını sağlar.
    LaunchedEffect(Unit) {
        delay(2000) // 2 saniyelik bir gecikme (Splash ekranının gösterim süresi).
        onSplashComplete() // Splash ekranı tamamlandığında, callback fonksiyonu çağrılır.
    }

    // Box, ekranın tamamını kaplayan bir kapsayıcıdır.
    // İçeriğin belirli bir yerde hizalanmasını sağlar.
    Box(
        modifier = Modifier.fillMaxSize(), // Box, ekranın tamamını doldurur.
        contentAlignment = Alignment.Center // İçerik yatay ve dikey olarak ortalanır.
    ) {
        // Ekranda bir hoş geldiniz mesajı gösteriyoruz.
        Text(text = "Welcome To My To-Do App") // "Welcome To My To-Do App" yazısı.
    }
}
