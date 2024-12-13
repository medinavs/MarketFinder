package com.medina.nearbyproject.data.model

import androidx.annotation.DrawableRes
import com.medina.nearbyproject.ui.component.category.NearbyCategoryFilterChipView
import kotlinx.serialization.Serializable

@Serializable
data class NearbyCategory(
    val id: String,
    val name: String
) {
    @get: DrawableRes
    val icon: Int?
        get() = NearbyCategoryFilterChipView.Companion.fromDescription(description = name)?.icon
}
