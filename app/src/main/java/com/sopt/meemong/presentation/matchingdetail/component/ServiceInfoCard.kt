package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.common.extensions.noRippleClickable
import com.sopt.meemong.core.common.extensions.toPriceFormat
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.core.model.PriceType
import com.sopt.meemong.core.model.ShootingRangeType
import com.sopt.meemong.core.model.TreatmentType
import com.sopt.meemong.data.matchingdetail.model.ServiceInfo

@Composable
fun ServiceInfoCard(
    serviceInfo: ServiceInfo,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MeemongTheme.colors.white)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Header(
            title = serviceInfo.title,
            isLiked = serviceInfo.isLiked,
            priceType = serviceInfo.priceType.label,
            discountRate = serviceInfo.discountRate,
            originalPrice = serviceInfo.originalPrice,
            displayPrice = serviceInfo.displayPrice,
            onLikeClick = onLikeClick,
        )

        InfoSection(
            treatmentTypes = serviceInfo.treatmentTypes,
            signatures = serviceInfo.signatures,
            shootingRanges = serviceInfo.shootingRanges,
            shopName = serviceInfo.shopName,
        )
    }
}

@Composable
private fun Header(
    title: String,
    isLiked: Boolean,
    priceType: String,
    discountRate: Float,
    originalPrice: Int?,
    displayPrice: Int?,
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

            originalPrice?.let {
                PriceStrikethrough(price = it)
            }
        }

        displayPrice?.let {
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
                    text = it.toPriceFormat(),
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
}

@Composable
private fun InfoSection(
    treatmentTypes: List<TreatmentType>,
    signatures: List<TreatmentType>,
    shootingRanges: List<ShootingRangeType>,
    shopName: String,
    modifier: Modifier = Modifier,
) {
    val textMeasurer = rememberTextMeasurer()
    val density = LocalDensity.current

    val infoLabelList = listOf(
        "시술 종류" to treatmentTypes.joinToString(", ") { it.label },
        "시그니처" to signatures.joinToString(", ") { it.label },
        "촬영범위" to shootingRanges.joinToString(", ") { it.label },
        "매장명" to shopName,
    )

    val labelWidth = with(density) {
        infoLabelList.maxOf { label ->
            textMeasurer.measure(
                text = AnnotatedString(label.first),
                style = MeemongTheme.typography.body2.sb14,
            ).size.width
        }.toDp()
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(12.dp),
                color = MeemongTheme.colors.gray50,
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        infoLabelList.forEach { info ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text(
                    modifier = Modifier.width(labelWidth),
                    text = info.first,
                    style = MeemongTheme.typography.body2.sb14,
                    color = MeemongTheme.colors.gray500,
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = info.second,
                    style = MeemongTheme.typography.body2.r14,
                    color = MeemongTheme.colors.black,
                )
            }
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
                serviceInfo = ServiceInfo(
                    title = "뭘 해야 될 지 모르겠다면?",
                    isLiked = firstLiked,
                    priceType = PriceType.REVIEW,
                    discountRate = 50f,
                    originalPrice = 35_000,
                    displayPrice = 5_000,
                    treatmentTypes = listOf(TreatmentType.CUT),
                    signatures = listOf(
                        TreatmentType.CUT,
                        TreatmentType.PERM,
                        TreatmentType.COLORED
                    ),
                    shootingRanges = listOf(
                        ShootingRangeType.FACE_EXPOSURE,
                        ShootingRangeType.VIDEO
                    ),
                    shopName = "아벨라움",
                ),
                onLikeClick = { firstLiked = !firstLiked },
            )

            ServiceInfoCard(
                serviceInfo = ServiceInfo(
                    title = "뭘 해야 될 지 두 번이나 진짜진짜로 모르겠다면??",
                    isLiked = secondLiked,
                    priceType = PriceType.FREE,
                    discountRate = 50f,
                    originalPrice = null,
                    displayPrice = null,
                    treatmentTypes = listOf(TreatmentType.PERM),
                    signatures = listOf(
                        TreatmentType.CUT,
                        TreatmentType.PERM,
                        TreatmentType.COLORED
                    ),
                    shootingRanges = listOf(
                        ShootingRangeType.FACE_EXPOSURE, ShootingRangeType.VIDEO,
                        ShootingRangeType.FACE_EXPOSURE, ShootingRangeType.VIDEO,
                        ShootingRangeType.FACE_EXPOSURE, ShootingRangeType.VIDEO,
                        ShootingRangeType.FACE_EXPOSURE, ShootingRangeType.VIDEO,
                    ),
                    shopName = "아벨라움이란다너이거이름은들어봤니?어렵지?아벨라움인지아벨리움인지ㅋㅋ",
                ),
                onLikeClick = { secondLiked = !secondLiked },
            )
        }
    }
}
