package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.common.extensions.noRippleClickable
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
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MeemongTheme.colors.white)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Header(
            title = title,
            isLiked = isLiked,
            priceType = priceType,
            discountRate = discountRate,
            originalPrice = originalPrice,
            displayPrice = displayPrice,
            onLikeClick = onLikeClick,
        )

        InfoSection(
            treatmentTypes = treatmentTypes,
            signatures = signatures,
            shootingRanges = shootingRanges,
            shopName = shopName,
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
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        TitleRow(
            title = title,
            isLiked = isLiked,
            onLikeClick = onLikeClick,
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
private fun InfoSection(
    treatmentTypes: List<String>,
    signatures: List<String>,
    shootingRanges: List<String>,
    shopName: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(12.dp),
                color = MeemongTheme.colors.gray50,
            )
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            val infoLabelList: List<String> = listOf("시술 종류", "시그니처", "촬영범위", "매장명")

            infoLabelList.forEach { label ->
                Text(
                    text = label,
                    style = MeemongTheme.typography.body2.sb14,
                    color = MeemongTheme.colors.gray500,
                )
            }
        }

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = treatmentTypes.joinToString(", "),
                style = MeemongTheme.typography.body2.r14,
                color = MeemongTheme.colors.black,
            )

            Text(
                text = signatures.joinToString(", "),
                style = MeemongTheme.typography.body2.r14,
                color = MeemongTheme.colors.black,
            )

            Text(
                text = shootingRanges.joinToString(", "),
                style = MeemongTheme.typography.body2.r14,
                color = MeemongTheme.colors.black,
            )

            Text(
                text = shopName,
                style = MeemongTheme.typography.body2.r14,
                color = MeemongTheme.colors.black,
            )
        }
    }
}

@Composable
private fun TitleRow(
    title: String,
    isLiked: Boolean,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            style = MeemongTheme.typography.headline.sb18,
            color = MeemongTheme.colors.black,
        )

        Icon(
            imageVector = ImageVector.vectorResource(
                if (isLiked) R.drawable.ic_like_filled_24 else R.drawable.ic_like_default_24
            ),
            modifier = Modifier
                .size(24.dp)
                .noRippleClickable(onLikeClick),
            contentDescription = if (isLiked) "좋아요 취소" else "좋아요",
            tint = if (isLiked) MeemongTheme.colors.red else MeemongTheme.colors.black,
        )
    }

}

@Preview
@Composable
private fun ServiceInfoCardPreview() {
    MeemongTheme {
        var firstLiked by remember { mutableStateOf(false) }
        var secondLiked by remember { mutableStateOf(true) }

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
                treatmentTypes = listOf("컷트"),
                signatures = listOf("컷트", "펌"),
                shootingRanges = listOf("얼굴 노출", "영상"),
                shopName = "아벨라움",
                onLikeClick = { firstLiked = !firstLiked },
                isLiked = firstLiked,
            )

            ServiceInfoCard(
                title = "뭘 해야 될 지 두 번이나 진짜진짜로 모르겠다면??",
                priceType = PriceType.FREE.label,
                discountRate = 50f,
                originalPrice = 1_000_000,
                displayPrice = 500_000,
                treatmentTypes = listOf("펌"),
                signatures = listOf("컷트", "펌", "염색"),
                shootingRanges = listOf("얼굴 노출", "영상"),
                shopName = "아벨라움",
                onLikeClick = { secondLiked = !secondLiked },
                isLiked = secondLiked,
            )
        }
    }
}
