package com.example.whatstheweather.feature.data.repository

import com.example.whatstheweather.core.util.Resource
import com.example.whatstheweather.feature.data.local.WeatherDao
import com.example.whatstheweather.feature.data.remote.WeatherApi
import com.example.whatstheweather.feature.domain.model.EntireWeather
import com.example.whatstheweather.feature.domain.model.WeatherInfo
import com.example.whatstheweather.feature.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class WeatherRepositoryImpl(
    private val api: WeatherApi,
    private val dao: WeatherDao
) : WeatherRepository {
    override fun getWeatherInfo(
        lat: Int,
        lon: Int,
        cnt: Int,
        appid: String
    ): Flow<Resource<List<WeatherInfo>>> = flow {

        emit(Resource.Loading())

        val weatherInfos = dao.getAllWeatherInfos().map {
            it.toWeatherInfo()
        }

        emit(Resource.Loading(data = weatherInfos))

        try {

            val remoteWeatherInfo =
                api.getWeatherList(19.0760, 72.8777, 20, "0e1fe54ed3c19a2d9662b114fb3ff045")
                    .list.map {
                        it.toMainWeatherEntity()
                    }

            dao.deleteWordInfos()
            dao.insertWordInfos(remoteWeatherInfo)

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    "Failed to load from the internet due to $e,Displaying old data",
                    weatherInfos
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    "Failed to load from the internet due to $e,Displaying old data",
                    weatherInfos
                )
            )
        }

        val updatedWeatherInfos = dao.getAllWeatherInfos().map {
            it.toWeatherInfo()
        }

        emit(Resource.Success(data = updatedWeatherInfos))
    }
}