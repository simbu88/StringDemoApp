package com.example.mapapp.Repository

import com.example.mapapp.Api.APIInterface


class Repository (var apiInterface: APIInterface) {

    suspend fun getWeatherForecast(latitude:Double,longitude:Double) = apiInterface.getWeatherForecast(lat =latitude,lon = longitude)


}