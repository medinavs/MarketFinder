package com.medina.nearbyproject.ui.component.market

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.medina.nearbyproject.data.model.NearbyMarket
import com.medina.nearbyproject.data.model.mocks.mockMarkets
import com.medina.nearbyproject.ui.theme.Typography

@Composable
fun NearbyMarketList(
    modifier: Modifier = Modifier,
    markets: List<NearbyMarket>,
    onMarketClick: (NearbyMarket) -> Unit
    ) {
    LazyColumn (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item {
            Text(text = "Explore locais perto de você", style = Typography.bodyLarge)
        }

        items(items = markets, key = {it.id}) { market ->
            NearbyMarketCard(
                market = market,
                onClick = {
                    onMarketClick(market)
                }
            )
        }
    }
}

@Preview
@Composable
private fun NearbyMarketListPreview() {
    NearbyMarketList(
        markets = mockMarkets,
        onMarketClick = {}
    )

}