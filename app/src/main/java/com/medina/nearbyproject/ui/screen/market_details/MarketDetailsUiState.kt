package com.medina.nearbyproject.ui.screen.market_details

import com.medina.nearbyproject.data.model.NearbyRule

data class MarketDetailsUiState (
    val rules: List<NearbyRule>? = null,
    val coupon: String? = null
)