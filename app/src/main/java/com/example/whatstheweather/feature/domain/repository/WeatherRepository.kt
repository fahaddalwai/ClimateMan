package com.example.whatstheweather.feature.domain.repository

import com.example.whatstheweather.core.util.Resource
import com.example.whatstheweather.feature.domain.model.EntireWeather
import com.example.whatstheweather.feature.domain.model.WeatherInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface WeatherRepository {
    fun getWeatherInfo(
        lat: Double,
        lon: Double,
        cnt: Int,
        appid: String,
        metrics:String
    ): Flow<Resource<List<WeatherInfo>>>
}