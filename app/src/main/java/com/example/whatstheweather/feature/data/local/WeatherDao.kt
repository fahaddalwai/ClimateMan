package com.example.whatstheweather.feature.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.whatstheweather.feature.data.local.entity.WeatherInfoEntity
import kotlinx.coroutines.flow.Flow

interface WeatherDao {

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(infos:List<WeatherInfoEntity>)

    @Query("DELETE FROM weatherinfoentity")
    suspend fun deleteWordInfos()

    @Query("SELECT * FROM weatherinfoentity")
    suspend fun getAllWeatherInfos(): List<WeatherInfoEntity>
}