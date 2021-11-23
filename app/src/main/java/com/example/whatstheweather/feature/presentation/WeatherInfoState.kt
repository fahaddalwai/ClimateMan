package com.example.whatstheweather.feature.presentation

import com.example.whatstheweather.feature.domain.model.WeatherInfo


data class WeatherInfoState(
    val wordInfoItems: List<WeatherInfo> =emptyList(),
    val isLoading: Boolean = false
)
