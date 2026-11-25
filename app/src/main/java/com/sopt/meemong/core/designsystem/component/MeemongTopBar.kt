package com.sopt.meemong.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

@Composable
fun MeemongTopBar(
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MeemongTheme.colors.white)
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(
            text = title,
            color = MeemongTheme.colors.gray900,
            style = MeemongTheme.typography.headline.sb18,
        )

        HorizontalDivider(
            thickness = 1.dp,
            color = MeemongTheme.colors.gray100,
        )
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun MeemongTopBarPreview() {
    MeemongTheme {
        MeemongTopBar(
            title = "빠른 매칭",
        )
    }
}
