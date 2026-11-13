package com.sopt.meemong.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

@Composable
fun PostTag(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier
            .background(
                color = MeemongTheme.colors.gray100,
                shape = CircleShape,
            )
            .padding(horizontal = 7.dp, vertical = 3.dp),
        color = MeemongTheme.colors.gray600,
        style = MeemongTheme.typography.caption1.m12,
        maxLines = 1,
        softWrap = false,
    )
}