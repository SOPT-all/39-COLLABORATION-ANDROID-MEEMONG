package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.component.UrlImage
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

/**
 * 디자이너 프로필 컴포넌트
 *
 * @param profileImage 프로필 이미지 URL입니다.
 * @param name 디자이너 이름입니다.
 * @param location 디자이너의 활동 지역입니다.
 * @param distance 사용자 위치와 디자이너 활동 지역 간의 거리입니다.
 *                  합동 세미나 단계에서는 11.6으로 고정합니다.
 * @param itemCount 디자이너의 활동 건수입니다.
 */
@Composable
fun DesignerProfile(
    profileImage: String,
    name: String,
    location: String,
    distance: Float,
    itemCount: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MeemongTheme.colors.white)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        ProfileSection(
            profileImage = profileImage,
            name = name,
            location = location,
            distance = distance,
        )

        if (itemCount > 0) {
            ProfileChip(
                itemCount = itemCount,
            )
        }
    }
}

@Composable
private fun ProfileSection(
    profileImage: String,
    name: String,
    location: String,
    distance: Float,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        UrlImage(
            url = profileImage,
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = name,
                style = MeemongTheme.typography.headline.sb18,
                color = MeemongTheme.colors.black,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {

                Text(
                    text = location,
                    style = MeemongTheme.typography.body2.r14,
                    color = MeemongTheme.colors.gray600,
                )

                Box(
                    modifier = Modifier
                        .background(
                            color = MeemongTheme.colors.gray600,
                            shape = CircleShape,
                        )
                        .size(3.dp)
                )

                Text(
                    text = "${"%.1f".format(distance)}km",
                    style = MeemongTheme.typography.body2.r14,
                    color = MeemongTheme.colors.gray600,
                )
            }
        }
    }
}

@Composable
private fun ProfileChip(
    itemCount: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(
                color = MeemongTheme.colors.gray100,
                shape = RoundedCornerShape(6.dp),
            )
            .padding(vertical = 4.dp, horizontal = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "$itemCount",
            style = MeemongTheme.typography.caption1.m12,
            color = MeemongTheme.colors.meemongBlue,
        )
        Text(
            text = "건 진행",
            style = MeemongTheme.typography.caption1.m12,
            color = MeemongTheme.colors.gray600,
        )
    }
}

@Preview
@Composable
private fun DesignerProfilePreview() {
    MeemongTheme {
        Column {
            DesignerProfile(
                profileImage = "",
                name = "승환",
                location = "경기 고양시",
                distance = 11.6f,
                itemCount = 43,
            )

            Spacer(modifier = Modifier.height(10.dp))

            DesignerProfile(
                profileImage = "",
                name = "승환",
                location = "경기 고양시",
                distance = 11.6f,
                itemCount = 0,
            )
        }
    }
}
