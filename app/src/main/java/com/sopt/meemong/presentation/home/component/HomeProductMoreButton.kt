package com.sopt.meemong.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

@Composable
fun HomeProductMoreButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 38.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(MeemongTheme.colors.background)
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp),
    horizontalArrangement = Arrangement . spacedBy (4.dp, Alignment.CenterHorizontally),
    verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "나에게 맞는 헤어템 더 보러 가기",
            color = MeemongTheme.colors.meemongBlue,
            style = MeemongTheme.typography.caption1.m12,
        )

        Icon(
            painter = painterResource(R.drawable.ic_arrow_right_16),
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = MeemongTheme.colors.meemongBlue,
        )
    }
}

@Preview(showBackground = true, widthDp = 335)
@Composable
private fun HomeProductMoreButtonPreview() {
    MeemongTheme {
        HomeProductMoreButton(onClick = {})
    }
}
