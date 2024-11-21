package com.example.showroomjdm.data
// Menyatakan bahwa file ini berada di dalam package com.example.showroomjdm.data

data class CarUiState(
    // Mendefinisikan data class CarUiState yang digunakan untuk menyimpan dan mengelola state UI untuk daftar mobil dan favorit

    val cars: List<Car> = emptyList(),
    // Properti 'cars' berfungsi untuk menyimpan daftar mobil. Nilainya berupa List<Car> yang berisi objek-objek mobil. Default-nya adalah list kosong (emptyList())

    val favoriteCars: List<Car> = emptyList()
    // Properti 'favoriteCars' berfungsi untuk menyimpan daftar mobil yang difavoritkan. Nilainya berupa List<Car> yang berisi objek-objek mobil yang difavoritkan. Default-nya adalah list kosong (emptyList())
)
