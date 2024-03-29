package com.vicolmoraes.grupozapchallenge.main

import com.vicolmoraes.grupozapchallenge.RetrofitInitializer
import com.vicolmoraes.grupozapchallenge.model.Building
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor {

    lateinit var presenter: Presenter

    fun fetch(int: Int) {
        val call = RetrofitInitializer().buildingService().list()
        call.enqueue(object : Callback<List<Building>?> {
            override fun onResponse(
                call: Call<List<Building>?>?,
                response: Response<List<Building>?>?
            ) {
                response?.body()?.let {
                    val imoveis: List<Building> = it
                    if (int == 0)
                        presenter.setVivaReal(imoveis)
                    else
                        presenter.setZap(imoveis)
                }
            }

            override fun onFailure(
                call: Call<List<Building>?>?,
                t: Throwable?
            ) {
            }
        })
    }
}