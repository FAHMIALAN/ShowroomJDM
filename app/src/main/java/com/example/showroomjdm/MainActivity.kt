package com.example.showroomjdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.showroomjdm.ui.theme.CarListScreen
import com.example.showroomjdm.ui.theme.CarViewModel // Pastikan impor ini ada
import com.example.showroomjdm.ui.theme.ShowroomJDMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowroomJDMTheme {
                // Membuat instance ViewModel
                val carViewModel = CarViewModel()
                // Menampilkan layar daftar mobil
                CarListScreen(carViewModel = carViewModel)
            }
        }
    }
}
