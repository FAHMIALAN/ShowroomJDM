package com.example.showroomjdm.ui.theme
// Menyatakan bahwa file ini berada di dalam package com.example.showroomjdm.ui.theme

import androidx.compose.foundation.Image
// Mengimpor komponen Image dari Jetpack Compose untuk menampilkan gambar

import androidx.compose.foundation.layout.*
// Mengimpor komponen layout seperti Row, Column, dan Modifier dari Jetpack Compose

import androidx.compose.foundation.lazy.LazyColumn
// Mengimpor LazyColumn yang memungkinkan membuat daftar item yang bisa digulir secara efisien

import androidx.compose.foundation.lazy.items
// Mengimpor fungsi items yang digunakan untuk menampilkan item dalam LazyColumn

import androidx.compose.material3.*
// Mengimpor komponen UI material desain seperti Card, Button, Text, dan lainnya dari material3

import androidx.compose.runtime.*
// Mengimpor elemen runtime dari Jetpack Compose, seperti Composable dan state management

import androidx.compose.ui.Modifier
// Mengimpor Modifier yang digunakan untuk mengubah dan mengatur tampilan elemen UI

import androidx.compose.ui.res.painterResource
// Mengimpor fungsi painterResource untuk memuat gambar dari resource

import androidx.compose.ui.unit.dp
// Mengimpor dp untuk menentukan ukuran dan jarak dalam satuan density-independent pixels

import com.example.showroomjdm.data.Car
// Mengimpor kelas Car yang berisi data mobil yang akan ditampilkan di UI

@Composable
fun CarListScreen(carViewModel: CarViewModel) {
    // Fungsi Composable yang menampilkan daftar mobil dan berinteraksi dengan ViewModel

    val uiState by carViewModel.uiState.collectAsState()
    // Mengambil state dari ViewModel menggunakan collectAsState untuk pembaruan UI secara otomatis

    LazyColumn(
        modifier = Modifier
            .fillMaxSize() 
            .padding(16.dp)
    ) {
        // LazyColumn digunakan untuk menampilkan daftar mobil dalam tampilan scrollable

        items(uiState.cars) { car ->
            // Mengakses data mobil dari uiState.cars dan menampilkan setiap item sebagai card

            CarCard(
                car = car, 
                isFavorite = uiState.favoriteCars.contains(car), 
                onFavoriteClick = { carViewModel.toggleFavorite(car) }
            )
            // Menampilkan card untuk setiap mobil, dengan status favorite dan callback untuk mengubah status favoritnya

            Spacer(modifier = Modifier.height(16.dp))
            // Memberikan jarak antar item mobil
        }
    }
}

@Composable
fun CarCard(car: Car, isFavorite: Boolean, onFavoriteClick: () -> Unit) {
    // Fungsi Composable untuk menampilkan detail informasi mobil dalam bentuk Card

    Card(
        modifier = Modifier
            .fillMaxWidth() 
            .padding(8.dp), 
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        // Membungkus elemen-elemen dalam Card untuk memberi efek elevasi dan padding

        Column(modifier = Modifier.padding(16.dp)) {
            // Menggunakan Column untuk menata elemen-elemen vertikal

            Image(
                painter = painterResource(id = car.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth() 
                    .height(180.dp)
            )
            // Menampilkan gambar mobil menggunakan painterResource dan mengatur ukuran gambar

            Spacer(modifier = Modifier.height(8.dp))
            // Memberikan jarak antara elemen gambar dan teks

            Text(text = car.name, style = MaterialTheme.typography.titleMedium)
            // Menampilkan nama mobil dengan gaya teks sesuai tema aplikasi

            Text(text = car.price, style = MaterialTheme.typography.bodyMedium)
            // Menampilkan harga mobil dengan gaya teks sesuai tema aplikasi

            Spacer(modifier = Modifier.height(8.dp))
            // Memberikan jarak antara elemen harga dan fitur mobil

            car.features.forEach { feature ->
                // Melakukan iterasi pada fitur mobil dan menampilkannya

                Text(text = feature, style = MaterialTheme.typography.bodySmall)
                // Menampilkan setiap fitur mobil dengan gaya teks kecil
            }

            Spacer(modifier = Modifier.height(8.dp))
            // Memberikan jarak antara fitur mobil dan tombol favorit

            Button(onClick = onFavoriteClick) {
                // Menampilkan tombol untuk menambah atau menghapus mobil dari favorit

                Text(if (isFavorite) "Remove from Favorites" else "Add to Favorites")
                // Menampilkan teks tombol berdasarkan status apakah mobil sudah difavoritkan atau belum
            }
        }
    }
}
