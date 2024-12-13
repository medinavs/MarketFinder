package com.example.nearbyproject.ui.component.market_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nearbyproject.data.model.NearbyRule
import com.example.nearbyproject.data.model.mocks.mockRules
import com.example.nearbyproject.ui.theme.Gray400
import com.example.nearbyproject.ui.theme.Gray500
import com.example.nearbyproject.ui.theme.Typography

@Composable
fun MarketDetailsRules(
    modifier: Modifier = Modifier,
    rules: List<NearbyRule>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Regulamento", style = Typography.headlineSmall, color = Gray400)

        Text(
            modifier = modifier.padding(start = 16.dp),
            text = rules.joinToString(separator = "\n", transform = { "• ${it.description}" }),
            style = Typography.labelMedium,
            color = Gray500,
            lineHeight = 24.sp
        )
    }
}

@Preview
@Composable
private fun MarketDetailsRulesPreview() {
    MarketDetailsRules(
        modifier = Modifier.fillMaxWidth(),
        rules = mockRules
    )

}