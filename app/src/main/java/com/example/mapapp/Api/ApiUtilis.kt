package com.example.mapapp.Api

class ApiUtilis {

    var BASE_URL ="https://api.openweathermap.org/data/2.5/"

    fun getAPIServiceInKotlin(): APIInterface {
        return RetrofitClient().getClient(BASE_URL)!!.create(APIInterface::class.java)
    }
}