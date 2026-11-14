package com.sopt.meemong.presentation.quickmatching.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.common.util.formatPostTime
import com.sopt.meemong.core.designsystem.component.MeemongPostCostType
import com.sopt.meemong.core.designsystem.component.PostTag
import com.sopt.meemong.core.designsystem.component.UrlImage
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import java.text.NumberFormat
import java.util.Locale

/**
 * 일반 공고 목록에서 사용하는 카드입니다.
 *
 * @param displayPrice 표시 가격입니다. null이면 금액을 표시하지 않습니다.
 * @param availableTimes 매퍼에서 한글로 변환한 시술 가능 시간 목록입니다.
 * @param treatmentTypes 매퍼에서 한글로 변환한 시술 유형 목록입니다.
 * @param createdAtMillis createdAt을 변환한 밀리초 단위 Unix timestamp입니다.
 * @param isLikeLoading 해당 공고의 좋아요 요청 진행 여부입니다.
 *
 * API 요청, 상태 갱신과 상세 화면 이동은 호출부에서 처리합니다.
 */
@Composable
fun MeemongPostCard(
    designerProfileImageUrl: String,
    designerName: String,
    createdAtMillis: Long,
    region: String,
    title: String,
    priceType: MeemongPostCostType,
    displayPrice: Int?,
    availableTimes: List<String>,
    treatmentTypes: List<String>,
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
                // 테두리 안쪽부터 내부 패딩 12dp 적용
                .padding(1.dp)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    UrlImage(
                        url = designerProfileImageUrl,
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                    )

                    FlowRow(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Text(
                            text = designerName,
                            color = MeemongTheme.colors.gray600,
                            style = MeemongTheme.typography.caption1.r12,
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            PostCardDividerDot()

                            Text(
                                text = formatPostTime(createdAtMillis),
                                color = MeemongTheme.colors.gray600,
                                style = MeemongTheme.typography.caption1.r12,
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            PostCardDividerDot()

                            Text(
                                text = region,
                                color = MeemongTheme.colors.gray600,
                                style = MeemongTheme.typography.caption1.r12,
                            )
                        }
                    }


                    Icon(
                        imageVector = ImageVector.vectorResource(
                            R.drawable.ic_like_filled_24,
                        ),
                        contentDescription = if (isLiked) {
                            "좋아요 취소"
                        } else {
                            "좋아요"
                        },
                        modifier = Modifier
                            .size(20.dp)
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
                            MeemongTheme.colors.gray200
                        },
                    )
                }

                Text(
                    text = title,
                    modifier = Modifier.fillMaxWidth(),
                    color = MeemongTheme.colors.gray700,
                    style = MeemongTheme.typography.body1.sb16,
                )

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Text(
                        text = priceType.label,
                        modifier = Modifier.widthIn(max = 88.dp),
                        color = when (priceType) {
                            MeemongPostCostType.FREE,
                            MeemongPostCostType.REVIEW_SPECIAL ->
                                MeemongTheme.colors.meemongBlue

                            MeemongPostCostType.MATERIAL_FEE ->
                                MeemongTheme.colors.gray700
                        },
                        style = MeemongTheme.typography.body2.sb14,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )

                    if (displayPrice != null) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            PostCardDividerDot()

                            Text(
                                text = NumberFormat
                                    .getIntegerInstance(Locale.KOREA)
                                    .format(displayPrice),
                                color = MeemongTheme.colors.gray900,
                                style = MeemongTheme.typography.body2.m14,
                            )
                        }
                    }

                    if (availableTimes.isNotEmpty()) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            PostCardDividerDot()

                            Text(
                                text = availableTimes.joinToString(", "),
                                modifier = Modifier.widthIn(max = 88.dp),
                                color = MeemongTheme.colors.gray600,
                                style = MeemongTheme.typography.body2.m14,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }
            }

            if (treatmentTypes.isNotEmpty()) {
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    treatmentTypes.forEach { treatment ->
                        PostTag(text = treatment)
                    }
                }
            }
        }
    }
}

@Composable
private fun PostCardDividerDot() {
    Box(
        modifier = Modifier
            .size(3.dp)
            .background(
                color = MeemongTheme.colors.gray400,
                shape = CircleShape,
            ),
    )
}

@Preview(
    name = "기본",
    showBackground = true,
    widthDp = 375,
)
@Preview(
    name = "큰 글자",
    showBackground = true,
    widthDp = 375,
    fontScale = 2f,
)
@Composable
private fun MeemongPostCardPreview() {
    MeemongTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            MeemongPostCostType.entries.forEach { priceType ->
                MeemongPostCard(
                    designerProfileImageUrl = "",
                    designerName = "수아디자이너",
                    createdAtMillis = System.currentTimeMillis(),
                    region = "서울시 서초구",
                    title = "월, 화 롱헤어모델 모집합니다",
                    priceType = priceType,
                    displayPrice = when (priceType) {
                        MeemongPostCostType.FREE -> null
                        MeemongPostCostType.REVIEW_SPECIAL -> 5_000
                        MeemongPostCostType.MATERIAL_FEE -> 40_000
                    },
                    availableTimes = listOf("평일 오전"),
                    treatmentTypes = listOf("커트", "염색"),
                    isLiked = priceType == MeemongPostCostType.REVIEW_SPECIAL,
                    isLikeLoading = false,
                    onLikeChange = {},
                    onClick = {},
                )
            }
        }
    }
}
