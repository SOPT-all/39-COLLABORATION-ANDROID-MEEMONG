package com.sopt.meemong.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.core.designsystem.theme.PretendardFont
import androidx.compose.ui.text.TextStyle

data class HomeProductItem(
    val imageUrl: String,
    val tag: String,
    val name: String,
    val originalPrice: Int,
    val discountRate: Int,
    val salePrice: Int,
)

@Composable
fun HomeProductSection(
    title: String,
    description: String,
    items: List<HomeProductItem>,
    onItemClick: (HomeProductItem) -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Text(
                text = title,
                color = MeemongTheme.colors.gray950,
                style = MeemongTheme.typography.body1.sb16,
            )
            Text(
                text = description,
                color = MeemongTheme.colors.gray950,
                style = TextStyle(
                    fontFamily = PretendardFont.Regular,
                    fontSize = 13.sp,
                ),
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(11.dp),
        ) {
            items.forEach { item ->
                HomeProductCard(
                    imageUrl = item.imageUrl,
                    tag = item.tag,
                    name = item.name,
                    originalPrice = item.originalPrice,
                    discountRate = item.discountRate,
                    salePrice = item.salePrice,
                    onClick = { onItemClick(item) },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                )
            }
        }
        HomeProductMoreButton(
            onClick = onMoreClick,
        )
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun HomeProductSectionPreview() {
    MeemongTheme {
        HomeProductSection(
            title = "긴 곱슬머리에 딱 맞는 헤어템",
            description = "모발 특성과 길이에 맞는 헤어템을 모아봤어요!",
            items = listOf(
                HomeProductItem("", "두피보호", "셀프염색 전 필수 두피 보호제", 28000, 68, 8960),
                HomeProductItem("", "기름제거", "떡지고 냄새나는 두피 해결 샴푸", 33000, 30, 23100),
            ),
            onItemClick = {},
            onMoreClick = {},
        )
    }
}
