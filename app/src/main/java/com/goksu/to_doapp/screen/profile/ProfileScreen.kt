package com.goksu.to_doapp.screen.profile

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Composable bir fonksiyon tanımlıyoruz. Bu, bir Jetpack Compose UI bileşenidir.
// ProfileScreen, bir profil ekranı temsil eder ve bir geri dönüş işlemi için bir callback fonksiyonu alır.
@Composable
fun ProfileScreen(onBackClick: () -> Unit) {

    // Bir sütun (Column) yerleşimi tanımlıyoruz.
    // Modifier.fillMaxSize() ile bu sütun, ekranın tamamını kaplar.
    // Ayrıca, içerikleri yatayda ve dikeyde hizalamak için Alignment ayarları yapılır.
    Column(
        modifier = Modifier.fillMaxSize(), // Sütunun tüm ekranı doldurmasını sağlar.
        horizontalAlignment = Alignment.CenterHorizontally, // Yatayda ortalanmasını sağlar.
        verticalArrangement = Arrangement.Center // Dikeyde ortalanmasını sağlar.
    ) {
        // Kullanıcıya basit bir metin göstermek için TEXT bileşeni kullanıyoruz.
        Text(text = "Profile Screen") // Ekranda "Profile Screen" yazan bir metin görüntüler.

        // Ekrandaki öğeler arasında boşluk eklemek için Spacer kullanıyoruz.
        // height(16.dp) ile 16 dp (density-independent pixels) yüksekliğinde bir boşluk oluşturuyoruz.
        Spacer(modifier = Modifier.height(16.dp))

        // Kullanıcı için bir düğme oluşturuyoruz. Düğmeye basıldığında `onBackClick` çağrılır.
        Button(onClick = onBackClick) {
            // Düğme içinde görünen metni tanımlıyoruz.
            Text("Back to Home") // Düğmenin üzerinde "Back to Home" yazan bir metin görüntüler.
        }
    }
}

//OZET: Bu kod, bir profil ekranı oluşturur.
// Kullanıcı, bu ekranda "Profile Screen" yazısını görür ve altındaki bir düğmeye basarak ana sayfaya dönebilir.
// onBackClick, bir geri dönüş olayını tetiklemek için çağrılan bir fonksiyondur.
//+979 568 337 308