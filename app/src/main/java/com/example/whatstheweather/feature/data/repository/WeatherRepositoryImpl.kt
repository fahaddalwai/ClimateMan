package com.example.whatstheweather.feature.data.repository

import com.example.whatstheweather.core.util.Resource
import com.example.whatstheweather.feature.data.local.WeatherDao
import com.example.whatstheweather.feature.data.remote.WeatherApi
import com.example.whatstheweather.feature.domain.model.EntireWeather
import com.example.whatstheweather.feature.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherRepositoryImpl(
    private val api: WeatherApi,
    private val dao: WeatherDao
): WeatherRepository {
    override fun getWeatherInfo(
        lat: Int,
        lon: Int,
        cnt: Int,
        appid: String
    ): Flow<Resource<List<EntireWeather>>> =flow{
        emit(Resource.Loading())

      

    }
}