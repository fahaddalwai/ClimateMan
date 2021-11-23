package com.example.whatstheweather.feature.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.whatstheweather.feature.domain.model.WeatherInfo

@Entity
data class WeatherInfoEntity(
    val name: String,
    val temp: Double,
    val feels_like: Double,
    val description: String,
    val icon: String,
    @PrimaryKey val id: Int? = null
) {
    fun toWeatherInfo(): WeatherInfo {
        return WeatherInfo(
            name = name,
            temp = temp,
            feels_like = feels_like,
            description = description,
            icon = icon
        )
    }
}