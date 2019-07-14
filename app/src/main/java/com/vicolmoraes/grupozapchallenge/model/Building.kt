package com.vicolmoraes.grupozapchallenge.model

data class Building(
    var usableAreas: Int,
    var listingType: String,
    var createdAt: String,
    var listingStatus: String,
    var id: String,
    var parkingSpaces: Int,
    var updatedAt: String,
    var owner: Boolean,
    var images: ArrayList<String>,
    var address: Address,
    var bathrooms: Int,
    var bedrooms: Int,
    var pricingInfos: PricingInfos
)

data class PricingInfos(
    var yearlyIptu: String,
    var price: String,
    var businessType: String,
    var monthlyCondoFee: String
)

data class Address(
    var city: String,
    var neighborhood: String,
    var geolocation: Geolocation
)

data class Geolocation(
    var precision: String,
    var location: Location
)

data class Location(
    var lon: String,
    var lat: String
)