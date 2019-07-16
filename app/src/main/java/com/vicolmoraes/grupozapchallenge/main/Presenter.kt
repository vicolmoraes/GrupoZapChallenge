package com.vicolmoraes.grupozapchallenge.main

import com.vicolmoraes.grupozapchallenge.LatLonUtils
import com.vicolmoraes.grupozapchallenge.model.Building

class Presenter {

    lateinit var mainActivity: MainActivity
    lateinit var vivaRealList: ArrayList<Building>
    lateinit var zapList: ArrayList<Building>
    var zapVendaMinima: Double = 600000.0
    var vivaRealAluguelMax: Double = 4000.0

    fun setVivaReal(buildings: List<Building>) {
        filter(buildings)
        mainActivity.startVivaReal(vivaRealList.toList())
    }

    fun setZap(buildings: List<Building>) {
        filter(buildings)
        mainActivity.startZap(zapList.toList())
    }

    fun filter(buildings: List<Building>) {
        vivaRealList = ArrayList()
        zapList = ArrayList()

        for (x in buildings) {
            if (x.address.geolocation.location.lat.isNotEmpty() && x.address.geolocation.location.lat.isNotEmpty() && x.pricingInfos.monthlyCondoFee.isNotEmpty() && x.usableAreas > 0) {
                if (x.pricingInfos.businessType == "SALE") {
                    if (LatLonUtils.calcular(
                            x.address.geolocation.location.lat.toDouble(),
                            x.address.geolocation.location.lon.toDouble()
                        )
                    )
                        zapVendaMinima = zapVendaMinima - (0.1 * zapVendaMinima)

                    if (x.pricingInfos.price.toDouble() <= 700000.0) {
                        vivaRealList.add(x)
                    }
                    if ((x.pricingInfos.price.toDouble() / x.usableAreas > 3500.0) && x.pricingInfos.price.toDouble() >= zapVendaMinima) {
                        zapList.add(x)
                    }
                    zapVendaMinima = 600000.0
                } else {
                    if (LatLonUtils.calcular(
                            x.address.geolocation.location.lat.toDouble(),
                            x.address.geolocation.location.lon.toDouble()
                        )
                    )
                        vivaRealAluguelMax = vivaRealAluguelMax + (0.5 * vivaRealAluguelMax)

                    if (x.pricingInfos.monthlyCondoFee.toDouble() >= (0.3 * x.pricingInfos.price.toDouble()) && x.pricingInfos.rentalTotalPrice.toDouble() <= vivaRealAluguelMax) {
                        vivaRealList.add(x)
                    }
                    if (x.pricingInfos.rentalTotalPrice.toDouble() >= 3500.0) {
                        zapList.add(x)
                    }
                    vivaRealAluguelMax = 4000.0
                }
            }
        }
    }
}