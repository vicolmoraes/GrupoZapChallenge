package com.vicolmoraes.grupozapchallenge

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://grupozap-code-challenge.s3-website-us-east-1.amazonaws.com/sources/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buildingService(): BuildingService {
        return retrofit.create(BuildingService::class.java)
    }
}