package com.vicolmoraes.grupozapchallenge.utils

class LatLonUtils {
    companion object {
        fun calcular(lat: Double, lon: Double): Boolean {
            return lat >= -23.568704 && lat <= -23.546686 && lon >= -46.693419 && lon <= -46.641146
        }
    }
}