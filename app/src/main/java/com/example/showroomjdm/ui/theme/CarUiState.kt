package com.example.showroomjdm.data

data class CarUiState(
    val cars: List<Car> = emptyList(),
    val favoriteCars: List<Car> = emptyList()
)
