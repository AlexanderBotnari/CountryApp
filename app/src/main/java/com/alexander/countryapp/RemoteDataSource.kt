package com.alexander.countryapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RestCountriesApi{

    @GET("name/{name}")
    fun getCountryByName(@Path(value = "name") cityName:String):List<Country>
}

var retrofit = Retrofit.Builder()
    .baseUrl("https://restcountries.com/v3.1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var restCountriesApi = retrofit.create(com.alexander.countryapp.RestCountriesApi::class.java)