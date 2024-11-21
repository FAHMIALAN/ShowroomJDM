package com.example.showroomjdm.ui.theme
// Menyatakan bahwa file ini berada dalam package com.example.showroomjdm.ui.theme

import androidx.lifecycle.ViewModel
// Mengimpor kelas ViewModel dari Android Jetpack, yang digunakan untuk menyimpan dan mengelola data UI secara terpisah dari tampilan

import com.example.showroomjdm.data.Car
// Mengimpor data class Car yang merepresentasikan mobil

import com.example.showroomjdm.data.cars
// Mengimpor daftar mobil (list of cars) yang digunakan sebagai data awal untuk aplikasi

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
// Mengimpor StateFlow dan fungsi terkait dari library Kotlin coroutines untuk mengelola state secara reaktif
// StateFlow adalah jenis Flow yang digunakan untuk menjaga status yang dapat dipantau secara langsung oleh UI

class CarViewModel : ViewModel() {
    // Mendefinisikan kelas ViewModel bernama CarViewModel, yang akan bertanggung jawab untuk mengelola data mobil dan status UI terkait

    private val _uiState = MutableStateFlow(CarUiState(cars = cars))
    // Mendeklarasikan _uiState yang menggunakan MutableStateFlow untuk menyimpan state UI yang dapat dimodifikasi
    // Inisialisasi dengan objek CarUiState yang berisi data mobil (cars)

    val uiState: StateFlow<CarUiState> = _uiState.asStateFlow()
    // Mendeklarasikan uiState sebagai StateFlow yang hanya dapat dibaca oleh UI
    // asStateFlow digunakan untuk membungkus MutableStateFlow agar tidak dapat dimodifikasi secara langsung

    private val favoriteCars = mutableSetOf<Car>()
    // Menyimpan daftar mobil favorit dalam bentuk mutable set, yang memungkinkan penambahan dan penghapusan mobil dari daftar favorit

    fun toggleFavorite(car: Car) {
        // Fungsi untuk menambahkan atau menghapus mobil dari daftar favorit

        if (favoriteCars.contains(car)) {
            // Jika mobil sudah ada dalam daftar favorit, maka hapus dari daftar
            favoriteCars.remove(car)
        } else {
            // Jika mobil belum ada dalam daftar favorit, maka tambahkan ke dalam daftar
            favoriteCars.add(car)
        }
        updateUiState()
        // Setelah mengubah status favorit, perbarui state UI
    }

    private fun updateUiState() {
        // Fungsi untuk memperbarui state UI dengan daftar mobil favorit yang terbaru

        _uiState.update { currentState ->
            // Memperbarui state saat ini (_uiState) dengan nilai baru
            currentState.copy(favoriteCars = favoriteCars.toList())
            // Membuat salinan baru dari state saat ini dengan daftar mobil favorit yang diperbarui
        }
    }
}

data class CarUiState(
    val cars: List<Car> = emptyList(),
    val favoriteCars: List<Car> = emptyList()
)
// Data class CarUiState digunakan untuk menyimpan status UI yang mencakup daftar mobil (cars) dan daftar mobil favorit (favoriteCars)
// Nilai defaultnya adalah list kosong
