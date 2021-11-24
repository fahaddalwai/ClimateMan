package com.example.whatstheweather.feature.di

import android.app.Application
import androidx.room.Room
import com.example.whatstheweather.feature.data.local.WeatherDatabase
import com.example.whatstheweather.feature.data.remote.WeatherApi
import com.example.whatstheweather.feature.data.remote.WeatherApi.Companion.BASE_URL
import com.example.whatstheweather.feature.data.repository.WeatherRepositoryImpl
import com.example.whatstheweather.feature.domain.repository.WeatherRepository
import com.example.whatstheweather.feature.domain.usecase.GetWeatherInfoUseCase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherInfoModule {

    @Provides
    @Singleton
    fun provideGetWeatherInfoUseCase(repository: WeatherRepository): GetWeatherInfoUseCase {
        return GetWeatherInfoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WeatherDatabase,
        api: WeatherApi
    ): WeatherRepository {
        return WeatherRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WeatherDatabase {
        return Room.databaseBuilder(
            app, WeatherDatabase::class.java, "weatherDatabase"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}