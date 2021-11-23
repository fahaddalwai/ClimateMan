package com.example.whatstheweather.feature.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.whatstheweather.feature.data.local.entity.WeatherInfoEntity

interface WeatherDao {

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(infos:List<WeatherInfoEntity>)

    @Query("DELETE FROM wordinfoentity WHERE word IN(:words)")
    suspend fun deleteWordInfos(words:List<String>)

}