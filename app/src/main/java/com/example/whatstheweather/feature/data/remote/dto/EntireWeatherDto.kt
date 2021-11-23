package com.example.whatstheweather.feature.data.remote.dto

data class EntireWeatherDto(
    val cod: String,
    val count: Int,
    val list: List<MainWeatherDto>,
    val message: String
)