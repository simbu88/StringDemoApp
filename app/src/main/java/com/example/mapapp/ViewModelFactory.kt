package com.example.mapapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mapapp.Api.APIInterface
import com.example.mapapp.Repository.Repository
import com.example.mapapp.viewModel.WeatherViewModel

class ViewModelFactory(private val apiHelper: APIInterface, var application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            WeatherViewModel(Repository(apiHelper),application = application) as T
        } else{
            throw IllegalArgumentException("Unknown class name")
        }
    }
}