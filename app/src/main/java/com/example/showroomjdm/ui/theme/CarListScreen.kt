// CarListScreen.kt
package com.example.showroomjdm.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.showroomjdm.data.Car

@Composable
fun CarListScreen(carViewModel: CarViewModel) {
    // Mengambil state dari ViewModel dengan collectAsState
    val uiState by carViewModel.uiState.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Mengakses data mobil dari uiState.cars
        items(uiState.cars) { car ->
            CarCard(
                car = car,
                isFavorite = uiState.favoriteCars.contains(car),
                onFavoriteClick = { carViewModel.toggleFavorite(car) }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CarCard(car: Car, isFavorite: Boolean, onFavoriteClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Pastikan Anda menggunakan Image dari Compose
            Image(
                painter = painterResource(id = car.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = car.name, style = MaterialTheme.typography.titleMedium)
            Text(text = car.price, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            car.features.forEach { feature ->
                Text(text = feature, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onFavoriteClick) {
                Text(if (isFavorite) "Remove from Favorites" else "Add to Favorites")
            }
        }
    }
}
