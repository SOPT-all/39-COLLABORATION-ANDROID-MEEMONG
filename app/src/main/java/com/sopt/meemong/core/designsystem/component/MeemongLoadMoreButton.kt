package com.sopt.meemong.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

/**
 * 목록 하단에 표시하는 더보기 버튼입니다.
 *
 * 문구와 클릭 동작은 호출부에서 전달합니다.
 */
@Composable
fun MeemongLoadMoreButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(4.dp)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(MeemongTheme.colors.white)
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = MeemongTheme.colors.gray300,
                ),
                shape = shape,
            )
            .clickable(
                role = Role.Button,
                onClick = onClick,
            )
            .padding(1.dp)
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
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

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun MeemongLoadMoreButtonPreview() {
    MeemongTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            MeemongLoadMoreButton(
                text = "미몽추천 공고 더보기",
                onClick = {},
            )

            MeemongLoadMoreButton(
                text = "포트폴리오 더보기",
                onClick = {},
            )
        }
    }
}