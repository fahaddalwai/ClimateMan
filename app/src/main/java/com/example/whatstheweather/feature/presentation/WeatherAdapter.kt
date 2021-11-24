package com.example.favfoodroom.viewfavfood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.whatstheweather.databinding.ListItemBinding
import com.example.whatstheweather.feature.domain.model.WeatherInfo

class WeatherAdapter() : ListAdapter<WeatherInfo, WeatherAdapter.ViewHolder>(SleepNightDiffCallback()) {

    class ViewHolder private constructor(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: WeatherInfo) {
            binding.weatherInfo = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food=getItem(position)!!



        holder.bind(food)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }



}




class SleepNightDiffCallback : DiffUtil.ItemCallback<WeatherInfo>() {

    override fun areItemsTheSame(oldItem: WeatherInfo, newItem: WeatherInfo): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: WeatherInfo, newItem: WeatherInfo): Boolean {
        return oldItem == newItem
    }

}



