package com.example.mapapp.Api
import com.example.mapapp.model.WeatherModel
import retrofit2.http.*

interface APIInterface {

    @GET("weather?appid=d4861cd65d6d2ee25ece30c9420c4a77")
    suspend fun getWeatherForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): WeatherModel

}