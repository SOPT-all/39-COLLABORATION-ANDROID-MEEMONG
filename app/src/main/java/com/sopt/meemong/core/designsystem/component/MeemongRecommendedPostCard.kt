package com.sopt.meemong.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.common.util.formatPostTime
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import java.text.NumberFormat
import java.util.Locale

enum class MeemongPostCostType(
    val label: String,
) {
    FREE("무료시술"),
    REVIEW_SPECIAL("리뷰특가"),
    MATERIAL_FEE("재료비 발생"),

    MODEL_FEE("모델료 발생"),
}

/**
 * 미몽 추천 공고 카드입니다.
 *
 * @param availableTimes 한글로 변환된 시술 가능 시간 목록입니다.
 * @param treatmentTypes 한글로 변환된 전체 시술 태그 목록입니다.
 * @param createdAtMillis 공고 등록 시각. 밀리초 단위 Unix timestamp입니다.
 * @param isLikeLoading 해당 공고의 좋아요 API 요청 진행 여부입니다.
 *
 * 카드 너비는 호출부의 modifier로 조절합니다.
 * API 요청과 상태 갱신, 상세 화면 이동은 호출부에서 처리합니다.
 */
@Composable
fun MeemongRecommendedPostCard(
    thumbnailUrl: String,
    title: String,
    priceType: MeemongPostCostType,
    displayPrice: Int,
    region: String,
    availableTimes: List<String>,
    treatmentTypes: List<String>,
    createdAtMillis: Long,
    isLiked: Boolean,
    isLikeLoading: Boolean,
    onLikeChange: (Boolean) -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val likeInteractionSource = remember {
        MutableInteractionSource()
    }

    Surface(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
        color = MeemongTheme.colors.white,
        border = BorderStroke(
            width = 1.dp,
            color = MeemongTheme.colors.gray300,
        ),
    ) {
        Column(
            modifier = Modifier
                // 피그마 콘텐츠 시작 위치: 테두리 1dp + 내부 여백 16dp
                .padding(1.dp)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                UrlImage(
                    url = thumbnailUrl,
                    modifier = Modifier
                        .size(92.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    contentScale = ContentScale.Crop,
                )

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 24.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                    ) {
                        Text(
                            text = title,
                            modifier = Modifier.weight(1f),
                            color = MeemongTheme.colors.gray700,
                            style = MeemongTheme.typography.body1.sb16,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )

                        Icon(
                            imageVector = ImageVector.vectorResource(
                                R.drawable.ic_like_filled_24,
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(20.dp)
                                .semantics {
                                    contentDescription = if (isLiked) {
                                        "좋아요 취소"
                                    } else {
                                        "좋아요"
                                    }
                                }
                                .toggleable(
                                    value = isLiked,
                                    enabled = !isLikeLoading,
                                    role = Role.Checkbox,
                                    interactionSource = likeInteractionSource,
                                    indication = null,
                                    onValueChange = onLikeChange,
                                ),
                            tint = if (isLiked) {
                                Color.Unspecified
                            } else {
                                MeemongTheme.colors.gray300
                            },
                        )
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        PostInfoRow(
                            iconRes = R.drawable.ic_price_14,
                            modifier = Modifier.heightIn(min = 20.dp),
                        ) {
                            Text(
                                text = priceType.label,
                                color = when (priceType) {
                                    MeemongPostCostType.FREE,
                                    MeemongPostCostType.REVIEW_SPECIAL ->
                                        MeemongTheme.colors.meemongBlue

                                    MeemongPostCostType.MATERIAL_FEE ->
                                        MeemongTheme.colors.gray700

                                    MeemongPostCostType.MODEL_FEE ->
                                        MeemongTheme.colors.green
                                },
                                style = MeemongTheme.typography.body2.sb14,
                                maxLines = 1,
                                softWrap = false,
                            )

                            if (priceType != MeemongPostCostType.FREE) {
                                Box(
                                    modifier = Modifier
                                        .size(4.dp)
                                        .background(
                                            color = MeemongTheme.colors.gray500,
                                            shape = CircleShape,
                                        ),
                                )

                                Text(
                                    text = NumberFormat
                                        .getIntegerInstance(Locale.KOREA)
                                        .format(displayPrice),
                                    modifier = Modifier.weight(1f),
                                    color = MeemongTheme.colors.gray900,
                                    style = MeemongTheme.typography.body2.r14,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                        }

                        PostInfoRow(
                            iconRes = R.drawable.ic_location_14,
                            modifier = Modifier.heightIn(min = 18.dp),
                        ) {
                            Text(
                                text = region,
                                modifier = Modifier.weight(1f),
                                color = MeemongTheme.colors.gray900,
                                style = MeemongTheme.typography.caption1.r12,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }

                        PostInfoRow(
                            iconRes = R.drawable.ic_time_14,
                            modifier = Modifier.heightIn(min = 18.dp),
                        ) {
                            Text(
                                text = availableTimes.joinToString(", "),
                                modifier = Modifier.weight(1f),
                                color = MeemongTheme.colors.gray900,
                                style = MeemongTheme.typography.caption1.r12,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    treatmentTypes.take(VISIBLE_TAG_COUNT).forEach { tag ->
                        PostTag(text = tag)
                    }

                    val remainingCount =
                        treatmentTypes.size - VISIBLE_TAG_COUNT

                    if (remainingCount > 0) {
                        PostTag(text = "+ $remainingCount")
                    }
                }

                Text(
                    text = formatPostTime(createdAtMillis),
                    color = MeemongTheme.colors.gray600,
                    style = MeemongTheme.typography.body2.r14,
                    maxLines = 1,
                    softWrap = false,
                )
            }
        }
    }
}

@Composable
private fun PostInfoRow(
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(14.dp),
            tint = MeemongTheme.colors.gray600,
        )

        content()
    }
}

private const val VISIBLE_TAG_COUNT = 3

@Preview(
    name = "화면 너비에 맞춘 목록",
    showBackground = true,
    widthDp = 375,
)
@Preview(
    name = "넓은 화면",
    showBackground = true,
    widthDp = 440,
)
@Composable
private fun MeemongRecommendedPostCardPreview() {
    MeemongTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            MeemongPostCostType.entries.forEach { priceType ->
                RecommendedPostCardPreviewItem(
                    priceType = priceType,
                )
            }
        }
    }
}

@Preview(
    name = "가로 목록용 너비",
    showBackground = true,
    widthDp = 346,
)
@Composable
private fun MeemongRecommendedPostCardCompactPreview() {
    MeemongTheme {
        Box(
            modifier = Modifier.padding(20.dp),
        ) {
            RecommendedPostCardPreviewItem(
                priceType = MeemongPostCostType.REVIEW_SPECIAL,
                modifier = Modifier.width(306.dp),
            )
        }
    }
}

@Composable
private fun RecommendedPostCardPreviewItem(
    priceType: MeemongPostCostType,
    modifier: Modifier = Modifier,
) {
    MeemongRecommendedPostCard(
        thumbnailUrl = "",
        title = "긴 기장 붙임머리 희망해요",
        priceType = priceType,
        displayPrice = when (priceType) {
            MeemongPostCostType.FREE -> 0
            MeemongPostCostType.REVIEW_SPECIAL -> 5_000
            MeemongPostCostType.MATERIAL_FEE -> 10_000
            MeemongPostCostType.MODEL_FEE -> 45_000
        },
        region = "고양시 덕양구",
        availableTimes = listOf("평일 오전", "평일 오후"),
        treatmentTypes = listOf(
            "염색",
            "탈색",
            "매직",
            "펌",
            "커트",
            "클리닉",
            "붙임머리",
        ),
        createdAtMillis = System.currentTimeMillis(),
        isLiked = priceType == MeemongPostCostType.REVIEW_SPECIAL,
        isLikeLoading = false,
        onLikeChange = {},
        onClick = {},
        modifier = modifier,
    )
}