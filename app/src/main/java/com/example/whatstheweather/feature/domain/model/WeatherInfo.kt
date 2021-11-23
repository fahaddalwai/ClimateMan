package com.example.whatstheweather.feature.domain.model

data class WeatherInfo(
    val name: String,
    val temp: Double,
    val feels_like: Double,
    val description: String,
    val icon: String,
)
