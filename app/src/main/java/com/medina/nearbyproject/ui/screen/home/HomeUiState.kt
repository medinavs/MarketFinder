package com.medina.nearbyproject.ui.screen.home

import com.medina.nearbyproject.data.model.NearbyCategory
import com.medina.nearbyproject.data.model.NearbyMarket
import com.google.android.gms.maps.model.LatLng

data class HomeUiState(
    val categories: List<NearbyCategory>? = null,
    val markets: List<NearbyMarket>? = null,
    val marketLocations: List<LatLng>? = null
)
