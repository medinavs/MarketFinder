package com.example.nearbyproject.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NearbyMarket(
    val id: String,
    val categoryId: String,
    val name: String,
    val description: String,
    val coupons: Int,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val phone: String,
    val cover: String
)
