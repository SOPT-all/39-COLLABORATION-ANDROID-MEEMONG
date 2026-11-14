package com.sopt.meemong.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.component.UrlImage
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

enum class DesignerPriceType(
    val label: String,
) {
    FREE("무료시술"),
    MATERIAL("재료비 발생"),
}

data class HomeDesignerItem(
    val portfolioImageUrls: List<String>,
    val profileImageUrl: String,
    val name: String,
    val shopName: String,
    val priceType: DesignerPriceType,
    val location: String,
    val materialCost: String = "",
)

@Composable
fun HomeDesignerCard(
    portfolioImageUrls: List<String>,
    profileImageUrl: String,
    name: String,
    shopName: String,
    priceType: DesignerPriceType,
    location: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    materialCost: String = "",
) {
    val shape = RoundedCornerShape(6.dp)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(MeemongTheme.colors.white)
            .border(width = 1.dp, color = MeemongTheme.colors.gray300, shape = shape)
            .clickable(onClick = onClick)
            .padding(1.dp)
            .padding(bottom = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            repeat(3) { index ->
                UrlImage(
                    url = portfolioImageUrls.getOrElse(index) { "" },
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(106f / 104f),
                    contentScale = ContentScale.Crop,
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                UrlImage(
                    url = profileImageUrl,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = name,
                        color = MeemongTheme.colors.black,
                        style = MeemongTheme.typography.body1.sb16,
                    )
                    Text(
                        text = shopName,
                        color = MeemongTheme.colors.gray700,
                        style = MeemongTheme.typography.caption1.r12,
                    )
                }
            }

            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MeemongTheme.colors.gray100,
                        shape = RoundedCornerShape(4.dp),
                    )
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                when (priceType) {
                    DesignerPriceType.FREE -> {
                        Text(
                            text = priceType.label,
                            color = MeemongTheme.colors.meemongBlue,
                            style = MeemongTheme.typography.caption1.m12,
                        )
                    }

                    DesignerPriceType.MATERIAL -> {
                        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                            Text(
                                text = priceType.label,
                                color = MeemongTheme.colors.gray950,
                                style = MeemongTheme.typography.caption1.m12,
                            )
                            Text(
                                text = materialCost,
                                color = MeemongTheme.colors.gray700,
                                style = MeemongTheme.typography.caption1.m12,
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier.height(IntrinsicSize.Min),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    VerticalDivider(
                        thickness = 1.dp,
                        color = MeemongTheme.colors.gray500,
                        modifier = Modifier.padding(vertical = 2.dp),
                    )

                    Text(
                        text = location,
                        color = MeemongTheme.colors.gray700,
                        style = MeemongTheme.typography.caption1.r12,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

@Composable
fun HomeDesignerCardSection(
    title: String,
    items: List<HomeDesignerItem>,
    onItemClick: (HomeDesignerItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = title,
            style = MeemongTheme.typography.body1.sb16,
            color = MeemongTheme.colors.gray950,
            modifier = Modifier.padding(horizontal = 20.dp),
        )

        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth(),
        ) {
            // 375 기준 324dp가 되도록 화면 너비에서 계산
            val cardWidth = maxWidth - 51.dp

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(items) { item ->
                    HomeDesignerCard(
                        portfolioImageUrls = item.portfolioImageUrls,
                        profileImageUrl = item.profileImageUrl,
                        name = item.name,
                        shopName = item.shopName,
                        priceType = item.priceType,
                        location = item.location,
                        materialCost = item.materialCost,
                        onClick = { onItemClick(item) },
                        modifier = Modifier.width(cardWidth),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 375)
@Preview(showBackground = true, widthDp = 375, fontScale = 2f)
@Composable
private fun HomeDesignerCardSectionPreview() {
    MeemongTheme {
        HomeDesignerCardSection(
            title = "내 주변 디자이너",
            items = listOf(
                HomeDesignerItem(
                    portfolioImageUrls = listOf("", "", ""),
                    profileImageUrl = "",
                    name = "한울",
                    shopName = "준오헤어 동탄카림에비뉴점",
                    priceType = DesignerPriceType.FREE,
                    location = "경기도 화성시 4.7km",
                ),
                HomeDesignerItem(
                    portfolioImageUrls = listOf("", "", ""),
                    profileImageUrl = "",
                    name = "슬아",
                    shopName = "에이치플레이스 정자역점",
                    priceType = DesignerPriceType.MATERIAL,
                    materialCost = "10만원~",
                    location = "경기 성남시 분당구 13.4km",
                ),
            ),
            onItemClick = {},
        )
    }
}
