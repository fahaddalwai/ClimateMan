package com.example.whatstheweather.feature.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.whatstheweather.feature.data.local.entity.WeatherInfoEntity


@Database(
    entities=[WeatherInfoEntity::class],
    version=1
)
abstract class WeatherDatabase: RoomDatabase() {
    abstract val dao: WeatherDao
}