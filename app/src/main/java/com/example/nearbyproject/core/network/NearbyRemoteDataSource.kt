package com.example.nearbyproject.core.network

import com.example.nearbyproject.core.network.KtorHttpClient.httpClientAndroid
import com.example.nearbyproject.data.model.Coupon
import com.example.nearbyproject.data.model.MarketDetails
import com.example.nearbyproject.data.model.NearbyCategory
import com.example.nearbyproject.data.model.NearbyMarket
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

object NearbyRemoteDataSource {
    private const val LOCAL_HOST_EMULATOR_BASE_URL = "http://10.0.2.2:3333"

    private const val BASE_URL = LOCAL_HOST_EMULATOR_BASE_URL

    suspend fun getCategories(): Result<List<NearbyCategory>> = try {
        val categories: List<NearbyCategory> = httpClientAndroid.get("$BASE_URL/categories").body()

        Result.success(categories)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarkets(categoryId: String): Result<List<NearbyMarket>> = try {
        val markets = httpClientAndroid.get("$BASE_URL/markets/category/${categoryId}")
            .body<List<NearbyMarket>>()

        Result.success(markets)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarketsDetails(marketId: String): Result<MarketDetails> = try {
        val market = httpClientAndroid.get("$BASE_URL/markets/${marketId}")
            .body<MarketDetails>()

        Result.success(market)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun patchCoupon(marketId: String): Result<Coupon> = try {
        val coupon = httpClientAndroid.patch("$BASE_URL/coupons/${marketId}").body<Coupon>()

        Result.success(coupon)
    } catch (e: Exception) {
        Result.failure(e)
    }
}