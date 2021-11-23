package com.example.whatstheweather.feature.data.remote

import com.example.whatstheweather.feature.data.remote.dto.EntireWeatherDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/find?lat={latitude}&lon={longitude}&cnt={count}&appid={appid}")
    suspend fun getWeatherList(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("cnt") cnt: Int,
        @Query("appid") appid: String,
    ):EntireWeatherDto

    companion object{
        const val BASE_URL="https://api.dictionaryapi.dev"
    }

}