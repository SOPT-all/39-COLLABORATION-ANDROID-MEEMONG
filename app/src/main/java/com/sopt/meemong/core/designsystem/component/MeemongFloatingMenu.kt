package com.sopt.meemong.core.designsystem.component

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

enum class MeemongFloatingMenuItem(
    val title: String,
    @param:DrawableRes val iconRes: Int,
) {
    QUICK_MATCHING(
        title = "빠른매칭",
        iconRes = R.drawable.ic_matching_14,
    ),
    SPONSORSHIP(
        title = "협찬신청",
        iconRes = R.drawable.ic_sponsorship_14,
    ),
    HAIR_CONSULTING(
        title = "헤어컨설팅",
        iconRes = R.drawable.ic_consultation_14,
    ),
    NORMAL_POST(
        title = "일반공고",
        iconRes = R.drawable.ic_announcement_14,
    ),
    RECOMMENDED_POST(
        title = "미몽추천",
        iconRes = R.drawable.ic_recommend_14,
    ),
}

enum class MeemongFloatingMenuType(
    val items: List<MeemongFloatingMenuItem>,
) {
    HOME(
        items = listOf(
            MeemongFloatingMenuItem.QUICK_MATCHING,
            MeemongFloatingMenuItem.SPONSORSHIP,
            MeemongFloatingMenuItem.HAIR_CONSULTING,
        ),
    ),
    QUICK_MATCHING(
        items = listOf(
            MeemongFloatingMenuItem.NORMAL_POST,
            MeemongFloatingMenuItem.RECOMMENDED_POST,
        ),
    ),
}

/**
 * 홈 및 빠른매칭 화면에서 사용하는 플로팅 메뉴입니다.
 *
 * 열림 상태는 호출부에서 관리합니다.
 * 항목을 선택하면 닫힘 이벤트를 전달한 뒤 선택 콜백을 호출합니다.
 * 실제 화면 이동과 화면 바깥 여백은 호출부에서 처리합니다.
 */

@Composable
fun MeemongFloatingMenu(
    type: MeemongFloatingMenuType,
    isExpanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onItemClick: (MeemongFloatingMenuItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    // 뒤로 가기 시에 화면 이동 대신 열려있는 메뉴를 닫는다.
    BackHandler(enabled = isExpanded) {
        onExpandedChange(false)
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (isExpanded) {
            FloatingMenuPanel(
                items = type.items,
                onItemClick = { item ->
                    onExpandedChange(false)
                    onItemClick(item)
                },
            )
        }

        FloatingMenuButton(
            expanded = isExpanded,
            onClick = {
                onExpandedChange(!isExpanded)
            },
        )
    }
}

@Composable
private fun FloatingMenuPanel(
    items: List<MeemongFloatingMenuItem>,
    onItemClick: (MeemongFloatingMenuItem) -> Unit,
) {
    Column(
        modifier = Modifier
            .widthIn(min = 102.dp)
            .floatingMenuShadow(shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(MeemongTheme.colors.gray900)
    ) {
        items.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        role = Role.Button,
                        onClick = { onItemClick(item) }
                    )
                    .padding(
                        horizontal = 12.dp,
                        vertical = 10.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(item.iconRes),
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = MeemongTheme.colors.white
                )

                Text(
                    text = item.title,
                    color = MeemongTheme.colors.white,
                    style = MeemongTheme.typography.body2.m14,
                    maxLines = 1,
                    softWrap = false,
                )
            }
        }
    }
}

@Composable
private fun FloatingMenuButton(
    expanded: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .floatingMenuShadow(
                shape = CircleShape,
                spread = if (expanded) 0.dp else 1.dp,
            )
            .clip(CircleShape)
            .background(MeemongTheme.colors.gray900)
            .clickable(
                role = Role.Button,
                onClick = onClick,
            )
            .semantics(mergeDescendants = true) {
                contentDescription = if (expanded) {
                    "글쓰기 메뉴 닫기"
                } else {
                    "글쓰기 메뉴 열기"
                }
                stateDescription = if (expanded) {
                    "펼쳐짐"
                } else {
                    "접힘"
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        if (expanded) {
            Icon(
                painter = painterResource(R.drawable.ic_cancel_24),
                contentDescription = "닫기 버튼",
                modifier = Modifier.size(24.dp),
                tint = MeemongTheme.colors.white,
            )
        } else {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_pen_20),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = MeemongTheme.colors.white,
                )

                Text(
                    text = "글쓰기",
                    color = MeemongTheme.colors.white,
                    style = MeemongTheme.typography.caption2.sb10,
                )
            }
        }
    }
}

private fun Modifier.floatingMenuShadow(
    shape: Shape,
    spread: Dp = 0.dp,
): Modifier = dropShadow(
    shape = shape,
    shadow = Shadow(
        radius = 5.7.dp,
        spread = spread,
        color = Color.Black.copy(alpha = 0.5f),
        offset = DpOffset.Zero,
    ),
)

@Preview(showBackground = true)
@Composable
private fun MeemongFloatingMenuPreview() {
    MeemongTheme {
        Row(
            modifier = Modifier.padding(
                start = 12.dp,
                top = 12.dp,
            ),
            verticalAlignment = Alignment.Bottom,
        ) {
            MeemongFloatingMenu(
                type = MeemongFloatingMenuType.HOME,
                isExpanded = false,
                onExpandedChange = {},
                onItemClick = {},
            )

            MeemongFloatingMenu(
                type = MeemongFloatingMenuType.QUICK_MATCHING,
                isExpanded = true,
                onExpandedChange = {},
                onItemClick = {},
            )

            MeemongFloatingMenu(
                type = MeemongFloatingMenuType.HOME,
                isExpanded = true,
                onExpandedChange = {},
                onItemClick = {},
            )
        }
    }
}
