package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

enum class Tab(
    val label: String,
) {
    DESIGNER_INFO("디자이너 정보"),
    RESERVATION("예약하기"),
}

@Composable
fun DetailTab(
    onTabClick: (Tab) -> Unit,
    modifier: Modifier = Modifier,
    currentTab: Tab = Tab.DESIGNER_INFO,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MeemongTheme.colors.white)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(MeemongTheme.colors.gray100),
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Tab.entries.forEach { tab ->
                TabItem(
                    modifier = Modifier.weight(1f),
                    tab = tab,
                    currentTab = currentTab,
                    onClick = { onTabClick(tab) },
                )
            }
        }
    }
}

@Composable
private fun TabItem(
    tab: Tab,
    currentTab: Tab,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .selectable(
                selected = currentTab == tab,
                role = Role.Tab,
                onClick = onClick,
            )
            .padding(top = 12.dp),
        contentAlignment = Alignment.Center,

        ) {
        Column(
            modifier = Modifier.width(IntrinsicSize.Max),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Bottom),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = tab.label,
                color = if (currentTab == tab) MeemongTheme.colors.gray900 else MeemongTheme.colors.gray700,
                style = MeemongTheme.typography.body1.sb16,
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(if (currentTab == tab) MeemongTheme.colors.gray800 else Color.Unspecified),
            )
        }
    }
}

@Preview
@Composable
private fun DetailTabPreview() {
    MeemongTheme {
        var currentTab by remember { mutableStateOf(Tab.DESIGNER_INFO) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            DetailTab(
                currentTab = currentTab,
                onTabClick = { tab ->
                    currentTab = tab
                },
            )

            DetailTab(
                onTabClick = {},
                currentTab = Tab.RESERVATION,
            )
        }
    }
}
