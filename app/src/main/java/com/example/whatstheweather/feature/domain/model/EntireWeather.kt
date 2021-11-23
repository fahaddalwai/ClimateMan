package com.example.whatstheweather.feature.domain.model

import com.example.whatstheweather.feature.data.remote.dto.MainWeatherDto

data class EntireWeather(
    val list: List<MainWeather>,
)
