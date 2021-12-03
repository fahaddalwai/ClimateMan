package com.example.whatstheweather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.whatstheweather.feature.presentation.WeatherAdapter
import com.example.whatstheweather.databinding.FragmentDisplayBinding
import com.example.whatstheweather.feature.presentation.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisplayFragment : Fragment() {

    private lateinit var binding: FragmentDisplayBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_display, container, false)
        viewModel


        binding.viewModel=viewModel
        binding.lifecycleOwner=this

        val adapter= WeatherAdapter()
        binding.recyclerView.adapter= adapter

        viewModel.state.observe(viewLifecycleOwner,{
            it?.let{
                adapter.submitList(it.weatherInfoItems)
            }
        })


        viewModel.showProgressBar.observe(viewLifecycleOwner,{
            if(it){
                binding.progressBar.visibility=View.VISIBLE
            }else{
                binding.progressBar.visibility=View.INVISIBLE
            }
        })
        return binding.root
    }


}