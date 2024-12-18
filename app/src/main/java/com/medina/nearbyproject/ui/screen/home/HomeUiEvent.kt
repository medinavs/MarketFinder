package com.medina.nearbyproject.ui.screen.home

sealed class HomeUiEvent {
    data object onFetchCategories: HomeUiEvent()
    data class onFetchMarkets(val categoryId: String) : HomeUiEvent()
}