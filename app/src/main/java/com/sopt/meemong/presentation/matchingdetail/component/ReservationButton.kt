package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

/**
 * 예약 진행 버튼입니다.
 *
 * @param onClick 버튼 클릭 이벤트
 * @param isEnabled 버튼 활성화 여부
 */
@Composable
fun ReservationButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false,
) {
    Text(
        text = "예약 진행",
        style = MeemongTheme.typography.body1.sb16,
        color = if (isEnabled) MeemongTheme.colors.white else MeemongTheme.colors.gray500,
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(
                color = if (isEnabled) MeemongTheme.colors.gray950 else MeemongTheme.colors.gray300,
            )
            .clickable(
                enabled = isEnabled,
                onClick = onClick,
                role = Role.Button,
            )
            .padding(vertical = 12.dp),
        textAlign = TextAlign.Center,
    )
}

@Preview(showBackground = true)
@Composable
private fun ReservationButtonPreview() {
    MeemongTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            ReservationButton(
                onClick = {},
            )

            ReservationButton(
                isEnabled = true,
                onClick = {},
            )
        }
    }
}
