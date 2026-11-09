package com.sopt.meemong.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

@Composable
fun MeemongTopBar(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(MeemongTheme.colors.white),
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(horizontal = 12.dp),
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(44.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_back_24),
                    contentDescription = "뒤로가기",
                    tint = MeemongTheme.colors.gray900,
                )
            }

            Text(
                text = title,
                modifier = Modifier.align(Alignment.Center),
                color = MeemongTheme.colors.gray900,
                style = MeemongTheme.typography.headline.sb18,
            )
        }

        HorizontalDivider(
            modifier = Modifier.align(Alignment.BottomCenter),
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
            onBackClick = {},
        )
    }
}