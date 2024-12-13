package com.example.nearbyproject.ui.component.market

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import com.example.nearbyproject.R
import com.example.nearbyproject.data.model.NearbyMarket
import com.example.nearbyproject.ui.theme.Gray100
import com.example.nearbyproject.ui.theme.Gray400
import com.example.nearbyproject.ui.theme.Gray500
import com.example.nearbyproject.ui.theme.RedBase
import com.example.nearbyproject.ui.theme.Typography

@Composable
fun NearbyMarketCard(
    modifier: Modifier = Modifier,
    market: NearbyMarket,
    onClick: (NearbyMarket) -> Unit
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Gray100)
            .border(width = 1.dp, color = Gray100, shape = RoundedCornerShape(12.dp)),
        onClick = {
            onClick(market)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray100)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth(0.3f)
                    .height(IntrinsicSize.Min)
                    .aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true),
                contentScale = ContentScale.Crop,
                contentDescription = "Imagem da loja",
                model = market.cover
            )
            Column {
                Text(text = market.name, style = Typography.headlineSmall.copy(fontSize = 14.sp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = market.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.bodyLarge.copy(fontSize = 14.sp),
                    color = Gray500
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        tint = if (market.coupons > 0) RedBase else Gray400,
                        painter = painterResource(id = R.drawable.ic_ticket),
                        contentDescription = "cupons disponiveis"
                    )
                    Text(
                        text = "${market.coupons} cupons",
                        color = Gray400,
                        style = Typography.bodyMedium.copy(fontSize = 12.sp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NearbyMarketCardPreview() {
    NearbyMarketCard(
        modifier = Modifier.fillMaxWidth(),
        market = NearbyMarket(
            id = "12345",
            categoryId = "67890",
            name = "Mercado Central",
            description = "Um mercado com grande variedade de produtos e ofertas especiais.",
            coupons = 10,
//            rules = emptyList(),
            latitude = -23.550520,
            longitude = -46.633308,
            address = "Av. Paulista, 1000, São Paulo - SP",
            phone = "(11) 1234-5678",
            cover = "https://example.com/market-cover.jpg"
        ),
        onClick = {}
    )
}