package com.goksu.to_doapp.screen.randomtext

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview as Preview

@Composable
fun RandomTextScreen(onBackClick: () -> Unit) {
    val randomTexts = listOf(
        "Başlamak, işin yarısıdır!",
        "Bir adım daha, hedefe bir adım daha yakınsın!",
        "Bugün harika işler başarabilirsin!",
        "Küçük adımlar, büyük başarılar getirir.",
        "Başarı, sabır ve azimle gelir!",
        "Bugün yapılacaklar, yarının ödülü!",
        "Hayallerine ulaşmak için çalışmaya devam et!",
        "Her işaretlediğin görev, bir zaferdir!",
        "Unutma, sen başarabilirsin!",
        "Kendi süper kahramanın ol!",
        "Hedeflerin seni bekliyor, devam et!",
        "Küçük zaferler, büyük hayalleri inşa eder.",
        "Bugünü kazandın, yarın için hazırsın!",
        "Bir işi bitir, bir gülümseme kazan!",
        "Her tamamlanan görev, seni güçlendirir!",
        "Bugün bir fırsat, onu değerlendir!",
        "Disiplin, başarıya giden yoldur.",
        "Zorlanıyorsan, büyüyorsun demektir!",
        "Başarı, yapılacaklar listesinden gelir!",
        "Sen yeter ki devam et, sonuçlar seni bulur!"
    )

    var MotivationText by remember { mutableStateOf("Press the button to see a random text!") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = MotivationText)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            MotivationText = randomTexts.random() //iclerinden rastgele secti
        }) {
            Text(text = "Generate Motivation Text")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onBackClick() }) {
            Text(text = "Go Back")
        }
    }
}

@Preview
@Composable
fun TextPreview() {
    MaterialTheme { }
    RandomTextScreen { }
} //TODO: Boyle olmamaliydi HomeScreen de gozukmeli pop-up gibi su anlik farkli screen olarak aciliyor.
//TODO: DUZELTILECEK MUTLAKA BAK HAFTASONU BUNA!!!!! Ece Hanim'a pazartesi anlat her seyi.


