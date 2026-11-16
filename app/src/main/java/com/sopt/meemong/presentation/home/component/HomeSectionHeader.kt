package com.sopt.meemong.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

@Composable
fun HomeSectionHeader(
    title: String,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            color = MeemongTheme.colors.gray950,
            style = MeemongTheme.typography.body1.sb16,
        )

        Row(
            modifier = Modifier.clickable(onClick = onMoreClick),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "더보기",
                color = MeemongTheme.colors.gray600,
                style = MeemongTheme.typography.caption1.m12,
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_forward_12),
                contentDescription = null,
                modifier = Modifier.size(12.dp),
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 335)
@Composable
private fun HomeSectionHeaderPreview() {
    MeemongTheme {
        HomeSectionHeader(
            title = "내 주변 디자이너",
            onMoreClick = {},
        )
    }
}
