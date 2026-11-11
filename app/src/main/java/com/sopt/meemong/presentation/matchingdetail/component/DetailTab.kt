package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

        Row {
            Tab.entries.forEach { tab ->
                TabItem(
                    tab = tab,
                    currentTab = currentTab,
                )
            }
        }
    }
}

@Composable
private fun TabItem(
    tab: Tab,
    currentTab: Tab,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Max)
            .padding(top = 12.dp)
            .padding(horizontal = 42.dp),
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

@Preview
@Composable
private fun DetailTabPreview() {
    MeemongTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            DetailTab()
            DetailTab(currentTab = Tab.RESERVATION)
        }
    }
}
