package com.vicolmoraes.grupozapchallenge

import com.vicolmoraes.grupozapchallenge.model.Building
import retrofit2.Call
import retrofit2.http.GET

interface BuildingService {
    @GET("source-1.json")
    fun list(): Call<List<Building>>
}