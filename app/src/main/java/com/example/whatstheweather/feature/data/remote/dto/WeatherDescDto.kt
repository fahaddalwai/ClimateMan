package com.example.whatstheweather.feature.data.remote.dto

import com.example.whatstheweather.feature.domain.model.WeatherDesc

data class WeatherDescDto(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
){
    fun toWeatherDesc(): WeatherDesc{
        return WeatherDesc(
            description=description,
            icon=icon
        )
    }
}