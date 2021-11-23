package com.example.whatstheweather.feature.domain.repository

import com.example.whatstheweather.core.util.Resource
import com.example.whatstheweather.feature.domain.model.EntireWeather
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface WeatherRepository {
    fun getWeatherInfo(
        lat: Int,
        lon: Int,
        cnt: Int,
        appid: String,
    ): Flow<Resource<List<EntireWeather>>>
}