package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.common.extensions.toPriceFormat
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

/**
 * 게시물 상세 페이지 > 내용 상세 조회에서 보이는 정보 컴포넌트입니다.
 *
// * @param title 카드의 타이틀입니다.
// * @param isLiked
 */
@Composable
fun ServiceInfoCard(
    title: String,
    priceType: String,
    discountRate: Float,
    originalPrice: Int,
    displayPrice: Int,
    treatmentTypes: List<String>,
    signatures: List<String>,
    shootingRanges: List<String>,
    shopName: String,
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MeemongTheme.colors.white)
            .padding(16.dp)
    ) {
        Header(
            title = title,
            isLiked = isLiked,
            priceType = priceType,
            discountRate = discountRate,
            originalPrice = originalPrice,
            displayPrice = displayPrice,
        )
    }
}

@Composable
private fun Header(
    title: String,
    isLiked: Boolean,
    priceType: String,
    discountRate: Float,
    originalPrice: Int,
    displayPrice: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        TitleRow(
            title = title,
            isLiked = isLiked,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            PriceTypeChip(label = priceType)

            PriceStrikethrough(price = originalPrice)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = "${discountRate.toInt()}%",
                style = MeemongTheme.typography.title.sb20,
                color = MeemongTheme.colors.red,
            )

            Text(
                text = displayPrice.toPriceFormat(),
                style = MeemongTheme.typography.title.sb20,
                color = MeemongTheme.colors.black,
            )

            Text(
                text = "원",
                style = MeemongTheme.typography.body2.m14,
                color = MeemongTheme.colors.gray700,
            )
        }
    }
}

@Composable
private fun TitleRow(
    title: String,
    isLiked: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            style = MeemongTheme.typography.headline.sb18,
            color = MeemongTheme.colors.black,
        )

        Icon(
            imageVector = ImageVector.vectorResource(
                if (isLiked) R.drawable.ic_like_filled_24 else R.drawable.ic_like_default_24
            ),
            contentDescription = if (isLiked) "좋아요 취소" else "좋아요",
            tint = if (isLiked) MeemongTheme.colors.red else MeemongTheme.colors.black,
        )
    }
}

@Preview
@Composable
private fun ServiceInfoCardPreview() {
    MeemongTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            ServiceInfoCard(
                title = "뭘 해야 될 지 모르겠다면?",
                priceType = PriceType.REVIEW.label,
                discountRate = 50f,
                originalPrice = 35_000,
                displayPrice = 5_000,
                treatmentTypes = listOf("CUTS", "YES"),
                signatures = listOf("CUTS"),
                shootingRanges = listOf("얼굴 노출", "영상"),
                shopName = "아벨라움",
            )

            ServiceInfoCard(
                title = "뭘 해야 될 지 모르겠다면?",
                priceType = PriceType.FREE.label,
                discountRate = 50f,
                originalPrice = 35_000,
                displayPrice = 5_000,
                treatmentTypes = listOf("CUTS", "YES"),
                signatures = listOf("CUTS"),
                shootingRanges = listOf("얼굴 노출", "영상"),
                shopName = "아벨라움",
                isLiked = true,
            )
        }
    }
}
