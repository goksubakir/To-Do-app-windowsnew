package com.goksu.to_doapp.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(onProfileClick: () -> Unit, onRandomTextClick: () -> Unit) {
    val tasks = listOf(
        "Sahte Görev 1",
        "Sahte Görev 2",
        "Sahte Görev 3",
        "Sahte Görev 4"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home Screen",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tasks) { task ->
                TaskCard(taskName = task)
            }
        }

        Button(
            onClick = onProfileClick,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Go to Profile")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onRandomTextClick,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("Random Motivation Text")
        }
    }
}

@Composable
fun TaskCard(taskName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = taskName,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen({} , {})
    }
}


//TODO: Motivasyon kartlari eklenecek en basa kullanici her bastiginda rastgele karsisina motivasyon icerikli ve destekleyici mesajlar cikacak. (Screen halinde oldu bunu duzelt)
//TODO: Profile screen i biraz daha ozellestirip home screen ile benzer hale getirilmeli (Butonlari duzenleyip kaldirmak gibi)
//TODO: Go To Profile butonuna profil simgesi eklenmeli ve kucultulup en sag alt capraza tasinmali(HomeScreen)
//TODO: Buton arkaplani nasil bilgisayardan eklenir onu arastir (Her iki ekran icin)
//TODO: En son SplashScreen icin animasyonlu tatli bir gecis arastir ve animasyon nasil eklenir ona bak. (Su an oncelik degil)
//TODO: + simgesi ile task eklenip cikarilacak ve bir adet bar bulunacak. Bu bar Overall progress olacak tasklarin yuzdeligini hesaplayip yuzde kac tamamlandigini gosterecek.
//TODO: Bir Database olusturulmali kullanici bilgilerini kaydetmeli ki giris icin veriyi tutabilsin.
//TODO: XP kazanma isini en son hallet bar kismi yapildiginda hesaplat.