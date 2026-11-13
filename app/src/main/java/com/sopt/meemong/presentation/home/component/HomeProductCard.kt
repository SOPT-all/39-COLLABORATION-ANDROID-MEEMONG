package com.sopt.meemong.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.component.UrlImage
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

@Composable
fun HomeProductCard(
    imageUrl: String,
    tag: String,
    name: String,
    originalPrice: Int,
    discountRate: Int,
    salePrice: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(6.dp)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(MeemongTheme.colors.white)
            .border(width = 1.dp, color = MeemongTheme.colors.gray300, shape = shape)
            .clickable(onClick = onClick)
            // 테두리 두께(1dp)만큼 안쪽부터 콘텐츠 배치
            .padding(1.dp),

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(81.dp),
        ) {
            UrlImage(
                url = imageUrl,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )

            Text(
                text = tag,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .background(
                        color = MeemongTheme.colors.black.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(bottomStart = 8.dp),
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                color = MeemongTheme.colors.white,
                style = MeemongTheme.typography.caption1.r12,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = name,
                color = MeemongTheme.colors.gray700,
                style = MeemongTheme.typography.body2.m14,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = originalPrice.toPriceText(),
                color = MeemongTheme.colors.gray500,
                style = MeemongTheme.typography.caption2.m10,
                textDecoration = TextDecoration.LineThrough,
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
            ) {
                Text(
                    text = "$discountRate%",
                    color = MeemongTheme.colors.red,
                    style = MeemongTheme.typography.body1.sb16,
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                ) {
                    Text(
                        text = salePrice.toPriceText(),
                        color = MeemongTheme.colors.black,
                        style = MeemongTheme.typography.body1.sb16,
                    )
                    Text(
                        text = "원",
                        color = MeemongTheme.colors.gray600,
                        style = MeemongTheme.typography.body1.r16,
                    )
                }
            }
        }
    }
}

private fun Int.toPriceText(): String = "%,d".format(this)

@Preview(showBackground = true)
@Preview(showBackground = true, fontScale = 2f)
@Composable
private fun HomeProductCardPreview() {
    MeemongTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(11.dp),
        ) {
            HomeProductCard(
                imageUrl = "",
                tag = "두피보호",
                name = "셀프염색 전 필수 두피 보호제",
                originalPrice = 28000,
                discountRate = 68,
                salePrice = 8960,
                onClick = {},
                modifier = Modifier.width(162.dp),
            )
            HomeProductCard(
                imageUrl = "",
                tag = "기름제거",
                name = "떡진 두피 샴푸",
                originalPrice = 33000,
                discountRate = 30,
                salePrice = 23100,
                onClick = {},
                modifier = Modifier.width(162.dp),
            )
        }
    }
}
