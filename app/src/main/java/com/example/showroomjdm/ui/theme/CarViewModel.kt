// CarViewModel.kt
package com.example.showroomjdm.ui.theme

import androidx.lifecycle.ViewModel
import com.example.showroomjdm.data.Car
import com.example.showroomjdm.data.cars
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CarViewModel : ViewModel() {

    // StateFlow untuk menyimpan status UI terkait mobil
    private val _uiState = MutableStateFlow(CarUiState(cars = cars))
    val uiState: StateFlow<CarUiState> = _uiState.asStateFlow()

    // Menyimpan daftar mobil favorit
    private val favoriteCars = mutableSetOf<Car>()

    // Fungsi untuk menambahkan atau menghapus mobil dari daftar favorit
    fun toggleFavorite(car: Car) {
        if (favoriteCars.contains(car)) {
            favoriteCars.remove(car)
        } else {
            favoriteCars.add(car)
        }
        updateUiState()
    }

    // Memperbarui status UI berdasarkan perubahan data
    private fun updateUiState() {
        _uiState.update { currentState ->
            currentState.copy(favoriteCars = favoriteCars.toList())
        }
    }
}

data class CarUiState(
    val cars: List<Car> = emptyList(),
    val favoriteCars: List<Car> = emptyList()
)
