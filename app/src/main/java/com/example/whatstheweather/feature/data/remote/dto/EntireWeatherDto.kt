package com.example.whatstheweather.feature.data.remote.dto

import com.example.whatstheweather.feature.domain.model.EntireWeather

data class EntireWeatherDto(
    val cod: String,
    val count: Int,
    val list: List<MainWeatherDto>,
    val message: String
){
    fun toEntireWeather(): EntireWeather {
        return EntireWeather(
            list=list.map{
                it.toMainWeather()
            }
        )
    }
}
