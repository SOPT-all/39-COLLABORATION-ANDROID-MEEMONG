package com.sopt.meemong.presentation.matchingdetail.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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

enum class Sns(
    @param:DrawableRes val iconRes: Int,
    val label: String,
    val link: String,
) {
    INSTAGRAM(
        iconRes = R.drawable.ic_instagram_24,
        label = "인스타그램",
        link = "https://www.instagram.com/gaman._.and/" // TODO: 미몽 인스타그램으로 수정
    ),
    NAVER_PLACE(
        iconRes = R.drawable.ic_naver_24,
        label = "네이버 플레이스",
        link = "",
    ),
    YOUTUBE(
        iconRes = R.drawable.ic_youtube_24,
        label = "유튜브",
        link = "",
    )
}

@Composable
fun SnsSection(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MeemongTheme.colors.white)
            .padding(horizontal = 16.dp)
            .padding(bottom = 36.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = "SNS",
            style = MeemongTheme.typography.body1.sb16,
            color = MeemongTheme.colors.black,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(4.dp))

        Sns.entries.forEach { sns ->
            SnsRow(
                iconRes = sns.iconRes,
                label = sns.label,
                link = sns.link,
            )
        }
    }
}

@Composable
private fun SnsRow(
    @DrawableRes iconRes: Int,
    label: String,
    link: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(iconRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(6.dp)
                    .size(24.dp),
                tint = MeemongTheme.colors.gray600,
            )

            Text(
                text = label,
                style = MeemongTheme.typography.body2.m14,
                color = MeemongTheme.colors.gray900,
            )
        }

        LinkButton(
            uri = link,
        )
    }
}


@Preview
@Composable
private fun SnsRowPreview() {
    MeemongTheme {
        SnsSection()
    }
}
