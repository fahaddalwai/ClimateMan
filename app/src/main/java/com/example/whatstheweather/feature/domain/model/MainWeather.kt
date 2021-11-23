package com.example.whatstheweather.feature.domain.model

import com.example.whatstheweather.feature.data.remote.dto.MainDto
import com.example.whatstheweather.feature.data.remote.dto.WeatherDescDto

data class MainWeather(
    val name: String,
    val main: Main,
    val weather: List<WeatherDesc>,
)

