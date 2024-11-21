package com.example.showroomjdm
// Menyatakan bahwa file ini berada di dalam package com.example.showroomjdm

import android.os.Bundle
// Mengimpor kelas Bundle yang digunakan untuk mengelola data dan status aplikasi di Android

import androidx.activity.ComponentActivity
// Mengimpor kelas ComponentActivity, yang merupakan kelas dasar untuk activity di Android

import androidx.activity.compose.setContent
// Mengimpor fungsi setContent untuk mengatur tampilan menggunakan Jetpack Compose

import com.example.showroomjdm.ui.theme.CarListScreen
// Mengimpor Composable function CarListScreen untuk menampilkan daftar mobil

import com.example.showroomjdm.ui.theme.CarViewModel
// Mengimpor CarViewModel, yang merupakan ViewModel untuk data mobil

import com.example.showroomjdm.ui.theme.ShowroomJDMTheme
// Mengimpor ShowroomJDMTheme, yang berfungsi untuk mengatur tema UI aplikasi menggunakan Jetpack Compose

class MainActivity : ComponentActivity() {
    // Mendeklarasikan MainActivity yang merupakan subclass dari ComponentActivity
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Memanggil metode onCreate dari superclass (ComponentActivity) untuk inisialisasi activity
        
        setContent {
            // Menentukan konten activity menggunakan setContent, yang digunakan oleh Jetpack Compose
            
            ShowroomJDMTheme {
                // Menetapkan tema untuk aplikasi dengan ShowroomJDMTheme
                
                val carViewModel = CarViewModel()
                // Membuat instance baru dari CarViewModel untuk mengelola data mobil dan status UI
                
                CarListScreen(carViewModel = carViewModel)
                // Memanggil Composable function CarListScreen dan meneruskan instance carViewModel
                // ke dalamnya agar layar dapat menampilkan daftar mobil berdasarkan data dari ViewModel
            }
        }
    }
}
