package com.example.whatstheweather.feature.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatstheweather.core.util.Constants.APP_ID
import com.example.whatstheweather.core.util.Constants.COUNT
import com.example.whatstheweather.core.util.Constants.LAT
import com.example.whatstheweather.core.util.Constants.LON
import com.example.whatstheweather.core.util.Resource
import com.example.whatstheweather.feature.domain.usecase.GetWeatherInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class WeatherViewModel @Inject constructor(private val getWeatherInfo: GetWeatherInfoUseCase) : ViewModel() {

    private val _weatherState = MutableLiveData<WeatherInfoState>()
    val state: LiveData<WeatherInfoState> = _weatherState

    private val _showProgressBar = MutableLiveData<Boolean>()
    val showProgressBar: LiveData<Boolean> = _showProgressBar

    init {
        _weatherState.value = WeatherInfoState()
        updateList()
        Log.i("i have awoken","yeap")
    }

    fun updateList() {
        viewModelScope.launch {
            getWeatherInfo(LAT, LON, COUNT, APP_ID)
                .onEach { result ->
                    when (result) {
                        is Resource.Success -> {
                            _weatherState.value = WeatherInfoState(
                                weatherInfoItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                            _showProgressBar.value = false

                        }
                        is Resource.Loading -> {
                            _weatherState.value = WeatherInfoState(
                                weatherInfoItems = result.data ?: emptyList(),
                                isLoading = true
                            )
                            _showProgressBar.value = true

                        }
                        is Resource.Error -> {
                            _weatherState.value = WeatherInfoState(
                                weatherInfoItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                            _showProgressBar.value = false

                        }
                    }
                }.launchIn(this)
        }


    }
}