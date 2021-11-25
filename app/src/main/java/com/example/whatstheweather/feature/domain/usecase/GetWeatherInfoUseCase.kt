package com.example.whatstheweather.feature.domain.usecase

import com.example.whatstheweather.core.util.Resource
import com.example.whatstheweather.feature.domain.model.WeatherInfo
import com.example.whatstheweather.feature.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GetWeatherInfoUseCase(
    private val repository: WeatherRepository
) {

    operator fun invoke(
        lat: Double,
        lon: Double,
        cnt: Int,
        appid: String,
    ): Flow<Resource<List<WeatherInfo>>> {
        return repository.getWeatherInfo(lat, lon, cnt, appid)
    }

}