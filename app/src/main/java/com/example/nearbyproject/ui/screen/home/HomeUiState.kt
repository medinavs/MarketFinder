package com.example.nearbyproject.ui.screen.home

import com.example.nearbyproject.data.model.NearbyCategory
import com.example.nearbyproject.data.model.NearbyMarket
import com.google.android.gms.maps.model.LatLng

data class HomeUiState(
    val categories: List<NearbyCategory>? = null,
    val markets: List<NearbyMarket>? = null,
    val marketLocations: List<LatLng>? = null
)
