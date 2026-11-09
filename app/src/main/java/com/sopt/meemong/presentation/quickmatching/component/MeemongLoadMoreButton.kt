package com.sopt.meemong.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

/**
 * 미몽 추천 공고 목록 하단의 더보기 버튼입니다.
 *
 * 실제 더보기 동작은 호출부의 [onClick]에서 연결합니다.
 */
@Composable
fun MeemongLoadMoreButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Row(
        modifier = modifier
            .width(335.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MeemongTheme.colors.white)
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = MeemongTheme.colors.gray300,
                ),
                shape = RoundedCornerShape(4.dp),
            )
            .clickable(
                role = Role.Button,
                onClick = onClick,
            )
            .padding(1.dp)
            .padding(
                horizontal = 89.dp,
                vertical = 6.dp,
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "미몽추천 공고 더보기",
            color = MeemongTheme.colors.gray700,
            style = MeemongTheme.typography.body1.r16,
            maxLines = 1,
            softWrap = false,
        )

        Icon(
            painter = painterResource(R.drawable.ic_chevron_down_24),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MeemongTheme.colors.gray700,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MeemongLoadMoreButtonPreview() {
    MeemongTheme {
        MeemongLoadMoreButton(
            onClick = {},
        )
    }
}
