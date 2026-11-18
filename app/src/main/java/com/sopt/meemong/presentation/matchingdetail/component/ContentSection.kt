package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.data.matchingdetail.model.TabType

@Composable
fun ContentSection(
    currentTab: TabType,
    content: String,
    portfolioImageUrls: List<String>,
    shopName: String,
    shopAddress: String,
    shopImageUrls: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        when (currentTab) {
            TabType.CONTENT_DETAIL -> {
                Text(
                    text = content,
                    style = MeemongTheme.typography.body2.m14,
                    color = MeemongTheme.colors.gray700,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 45.dp)
                        .padding(horizontal = 16.dp),
                )
            }

            TabType.DESIGNER_INFO -> {
                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    PortfolioSection(
                        imageUrls = portfolioImageUrls,
                    )

                    ShopSection(
                        shopName = shopName,
                        shopAddress = shopAddress,
                        shopImageUrls = shopImageUrls,
                    )

                    SnsSection()
                }
            }
        }
    }
}
