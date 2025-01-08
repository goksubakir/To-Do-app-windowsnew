package com.goksu.to_doapp.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
// HomeScreen adlı bir Composable fonksiyon tanımlıyoruz. Bu fonksiyon ana ekranı oluşturur.
// Kullanıcı profil ekranına geçmek istediğinde `onProfileClick` callback'i çağrılır.
@Composable
fun HomeScreen(onProfileClick: () -> Unit) {

    // Sahte bir görev listesi tanımlıyoruz. Gerçek bir uygulamada bu veriler bir veri kaynağından (örneğin bir API'den) gelir.
    val tasks = listOf(
        "Sahte Gorev 1", // Görev 1
        "Sahte Gorev 2", // Görev 2
        "Sahte Gorev 3", // Görev 3
        "Sahte Gorev 4"  // Görev 4
    )

    // Sütun (Column) yapısı oluşturuyoruz. Bu yapı tüm bileşenleri dikey olarak hizalar.
    Column(
        modifier = Modifier
            .fillMaxSize() // Sütunun tüm ekranı kaplamasını sağlar.
            .padding(16.dp), // Tüm kenarlardan 16 dp boşluk bırakır.
        horizontalAlignment = Alignment.CenterHorizontally // Çocuk öğelerin yatayda ortalanmasını sağlar.
    ) {
        // Ana ekranın başlığını göstermek için Text bileşeni.
        Text(
            text = "Home Screen", // Başlık yazısı.
            modifier = Modifier.padding(bottom = 16.dp) // Alt tarafında 16 dp boşluk bırakır.
        )

        // Görev listesi oluşturuyoruz. LazyColumn ile yalnızca görünen öğeler yüklenir.
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth() // Liste genişliğinin ekranı doldurmasını sağlar.
                .weight(1f), // Sütun içindeki boş alanın çoğunu kaplar.
            verticalArrangement = Arrangement.spacedBy(8.dp) // Liste öğeleri arasında 8 dp boşluk bırakır.
        ) {
            // Sahte görev listesindeki her bir öğeyi göstermek için `items` fonksiyonu.
            items(tasks) { task ->
                TaskCard(taskName = task) // Her görev için bir TaskCard oluşturuyoruz.
            }
        }

        // Kullanıcıyı profil ekranına yönlendiren bir düğme.
        Button(
            onClick = onProfileClick, // Düğmeye basıldığında `onProfileClick` çağrılır.
            modifier = Modifier.padding(top = 16.dp) // Üst tarafında 16 dp boşluk bırakır.
        ) {
            Text("Go to Profile") // Düğme üzerindeki yazı.
        }
    }
}

// TaskCard adlı bir Composable fonksiyon tanımlıyoruz.
// Her görev için ayrı bir kart gösterir.
@Composable
fun TaskCard(taskName: String) {
    // Bir kart bileşeni oluşturuyoruz. Kartın arka planı varsayılan olarak bir kutu şeklindedir.
    Card(
        modifier = Modifier
            .fillMaxWidth() // Kartın genişliği ekranın tamamını kaplar.
            .padding(8.dp) // Kartın dış kenarlarında 8 dp boşluk bırakır.
    ) {
        // Kart içeriği için Text bileşeni.
        Text(
            text = taskName, // Kartta görüntülenecek görev adı.
            modifier = Modifier.padding(16.dp) // Metin içeriğinin çevresinde 16 dp boşluk bırakır.
        )
    }
}

