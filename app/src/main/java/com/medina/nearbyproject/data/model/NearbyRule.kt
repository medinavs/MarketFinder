package com.medina.nearbyproject.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NearbyRule(
    val id: String,
    val description: String,
    val marketId: String
)
