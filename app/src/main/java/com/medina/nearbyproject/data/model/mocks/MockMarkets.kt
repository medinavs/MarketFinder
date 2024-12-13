package com.medina.nearbyproject.data.model.mocks

import com.medina.nearbyproject.data.model.NearbyMarket

val mockMarkets = listOf(
    NearbyMarket(
        id = "12345",
        categoryId = "67890",
        name = "Mercado Central",
        description = "Um mercado com grande variedade de produtos e ofertas especiais.",
        coupons = 10,
//        rules = listOf(
//            NearbyRule(
//                id = "14314",
//                description = "Validade em tal tal dia",
//                marketId = "12345"
//            ),
//            NearbyRule(
//                id = "143145",
//                description = "tal tal dia cupons",
//                marketId = "12345"
//            )
//        ),
        latitude = -23.550520,
        longitude = -46.633308,
        address = "Av. Paulista, 1000, São Paulo - SP",
        phone = "(11) 1234-5678",
        cover = "https://example.com/market-cover.jpg"
    ),
    NearbyMarket(
        id = "123456",
        categoryId = "67890",
        name = "Mercado Central",
        description = "Um mercado com grande variedade de produtos e ofertas especiais.",
        coupons = 10,
//        rules = emptyList(),
        latitude = -23.550520,
        longitude = -46.633308,
        address = "Av. Paulista, 1000, São Paulo - SP",
        phone = "(11) 1234-5678",
        cover = "https://example.com/market-cover.jpg"
    )
)