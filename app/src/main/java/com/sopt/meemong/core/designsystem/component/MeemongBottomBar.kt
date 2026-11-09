package com.sopt.meemong.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
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
 * 현재 선택 상태 전용 아이콘은 홈 탭에만 적용되어 있습니다.
 * 다른 탭은 선택 여부와 관계없이 동일한 아이콘을 사용합니다.
 *
 * 실제 네비게이션은 연결되어 있지 않으며,
 * 화면 이동이 필요한 경우 호출부에서 [onTabClick]을 통해 연결합니다.
 */
@Composable
fun MeemongBottomBar(
    selectedTab: MeemongBottomTab,
    onTabClick: (MeemongBottomTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 89.dp)
            .background(MeemongTheme.colors.white)
            .padding(
                start = 31.5.dp,
                top = 8.dp,
                end = 31.5.dp,
                bottom = 36.dp,
            )
            .selectableGroup(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        MeemongBottomTab.entries.forEach { tab ->
            MeemongBottomBarItem(
                tab = tab,
                selected = selectedTab == tab,
                onClick = { onTabClick(tab) },
            )
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
            .width(32.dp)
            .heightIn(min = 44.dp)
            .selectable(
                selected = selected,
                role = Role.Tab,
                onClick = onClick,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Icon(
            painter = painterResource(
                if (selected) tab.selectedIconRes else tab.iconRes,
            ),
            contentDescription = null,
            tint = MeemongTheme.colors.gray950,
        )

        Text(
            text = tab.title,
            modifier = Modifier.wrapContentWidth(unbounded = true),
            color = if (selected) {
                MeemongTheme.colors.gray950
            } else {
                MeemongTheme.colors.gray700
            },
            style = if (selected) {
                MeemongTheme.typography.caption1.m12
            } else {
                MeemongTheme.typography.caption1.r12
            },
            softWrap = false,
        )
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun MeemongBottomBarPreview() {
    MeemongTheme {
        MeemongBottomBar(
            selectedTab = MeemongBottomTab.HOME,
            onTabClick = {},
        )
    }
}
