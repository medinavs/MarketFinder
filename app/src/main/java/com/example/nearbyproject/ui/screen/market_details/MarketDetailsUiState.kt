package com.example.nearbyproject.ui.screen.market_details

import com.example.nearbyproject.data.model.NearbyRule

data class MarketDetailsUiState (
    val rules: List<NearbyRule>? = null,
    val coupon: String? = null
)