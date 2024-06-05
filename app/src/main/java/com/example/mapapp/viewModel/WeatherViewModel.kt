package com.example.mapapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.example.mapapp.R
import com.example.mapapp.Repository.Repository
import com.example.mapapp.Resource
import com.example.mapapp.Utility
import com.example.mapapp.model.WeatherModel
import kotlinx.coroutines.Dispatchers


class WeatherViewModel(val repository: Repository, application: Application): AndroidViewModel(application) {
    var error = "Error Occurred!"


    fun getWeatherData(lat: Double,long: Double) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            if (Utility.isConnected(getApplication())) {
                val result:WeatherModel = repository.getWeatherForecast(lat,long)
                emit(Resource.success(data = result))
            } else {
                emit(Resource.error(data = null, message = getApplication<Application>().getString(R.string.network_slow_or_disconnected)))
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}