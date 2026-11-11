package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

@Composable
fun LinkButton(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Text(
        text = "바로가기",
        style = MeemongTheme.typography.body2.m14,
        color = MeemongTheme.colors.gray800,
        modifier = modifier
            .clip(shape = RoundedCornerShape(6.dp))
            .clickable(
                interactionSource = interactionSource,
                onClick = onButtonClick
            )
            .background(
                color = if (isPressed) MeemongTheme.colors.gray500 else MeemongTheme.colors.gray100,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(vertical = 2.dp, horizontal = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun LinkButtonPreview() {
    MeemongTheme {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            LinkButton(
                onButtonClick = {},
            )
        }
    }
}
