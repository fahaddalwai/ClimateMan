package com.example.whatstheweather.feature.data.remote.dto

import com.example.whatstheweather.MainActivity
import com.example.whatstheweather.feature.domain.model.MainWeather

data class MainWeatherDto(
    val clouds: CloudsDto,
    val coord: CoordDto,
    val dt: Int,
    val id: Int,
    val main: MainDto,
    val name: String,
    val rain: Any,
    val snow: Any,
    val sys: SysDto,
    val weather: List<WeatherDescDto>,
    val wind: Wind
){

    fun toMainWeather(): MainWeather {
        return MainWeather(
            name=name,
            main=main.toMain(),
            weather= weather.map{
                it.toWeatherDesc()
            }
        )
    }
}