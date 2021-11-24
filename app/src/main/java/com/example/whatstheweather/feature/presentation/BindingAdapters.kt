package com.example.whatstheweather.feature.presentation

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import com.example.whatstheweather.feature.domain.model.WeatherInfo

@BindingAdapter("name")
fun TextView.setName(item: WeatherInfo?) {
    item?.let {
        text = item.name
        Log.i("name",text as String)
    }
}


@BindingAdapter("feels_like")
fun TextView.setFeelsLike(item: WeatherInfo?) {
    item?.let {
        text= item.feels_like.toString()
        Log.i("food",text as String)
    }
}

@BindingAdapter("description")
fun TextView.setDescription(item: WeatherInfo?) {
    item?.let {
        text= item.description.toString()
        Log.i("food",text as String)
    }
}

@BindingAdapter("icon")
fun bindIcon(imgView: ImageView, imgIcon: String?) {
    imgIcon?.let {
        imgView.load("https://openweathermap.org/img/wn/$imgIcon@2x.png")
    }
}
@BindingAdapter("temp")
fun TextView.setTemp(item: WeatherInfo?) {
    item?.let {
        text = item.temp.toString()
        Log.i("name",text as String)
    }
}


