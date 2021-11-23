package com.example.whatstheweather.feature.data.remote.dto

import com.example.whatstheweather.feature.domain.model.Main

data class MainDto(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double
) {

    fun toMain(): Main {
        return Main(
            temp=temp,
            feels_like=feels_like
        )
    }
}