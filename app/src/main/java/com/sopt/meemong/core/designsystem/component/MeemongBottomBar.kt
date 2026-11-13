package com.sopt.meemong.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

enum class MeemongBottomTab(
    val title: String,
    @param:DrawableRes val iconRes: Int,
    @param:DrawableRes val selectedIconRes: Int = iconRes,
) {
    HOME(
        title = "홈",
        iconRes = R.drawable.ic_home_24,
        selectedIconRes = R.drawable.ic_home_24,
    ),
    REVIEW(
        title = "리뷰특가",
        iconRes = R.drawable.ic_promotion_24,
    ),
    CONSULTING(
        title = "컨설팅",
        iconRes = R.drawable.ic_consultation_24,
    ),
    CHAT(
        title = "채팅",
        iconRes = R.drawable.ic_chat_24,
    ),
    PROFILE(
        title = "프로필",
        iconRes = R.drawable.ic_profile_24,
    ),
}

/**
 * 홈 화면에서 사용하는 공통 바텀바입니다.
 *
 * 하단 36dp는 시스템 바 영역을 포함한 디자인 여백입니다.
 * 컴포넌트 내부에서 navigationBarsPadding은 추가하지 않습니다.
 *
 * 실제 화면 이동은 호출부의 [onTabClick]에서 연결합니다.
 */
@Composable
fun MeemongBottomBar(
    selectedTab: MeemongBottomTab,
    onTabClick: (MeemongBottomTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 94.dp)
            .background(MeemongTheme.colors.white),
    ) {
        HorizontalDivider(
            thickness = 1.dp,
            color = MeemongTheme.colors.gray300,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 25.dp,
                    top = 8.dp,
                    end = 25.dp,
                    bottom = 36.dp,
                )
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            MeemongBottomTab.entries.forEach { tab ->
                MeemongBottomBarItem(
                    tab = tab,
                    selected = selectedTab == tab,
                    onClick = {
                        onTabClick(tab)
                    },
                )
            }
        }
    }
}

@Composable
private fun MeemongBottomBarItem(
    tab: MeemongBottomTab,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .width(49.dp)
            .heightIn(min = 49.dp)
            .selectable(
                selected = selected,
                role = Role.Tab,
                onClick = onClick,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(
                if (selected) {
                    tab.selectedIconRes
                } else {
                    tab.iconRes
                },
            ),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MeemongTheme.colors.gray950,
        )

        Text(
            text = tab.title,
            modifier = Modifier
                .width(49.dp)
                .heightIn(min = 21.dp)
                .wrapContentWidth(unbounded = true),
            color = if (selected) {
                MeemongTheme.colors.gray950
            } else {
                MeemongTheme.colors.gray700
            },
            style = MeemongTheme.typography.caption2.m10,
            textAlign = TextAlign.Center,
            softWrap = false,
        )
    }
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
private fun MeemongBottomBarPreview() {
    MeemongTheme {
        MeemongBottomBar(
            selectedTab = MeemongBottomTab.HOME,
            onTabClick = {},
        )
    }
}