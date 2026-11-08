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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.meemong.core.designsystem.component.UrlImage

// Todo: K-doc 작성
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
            .background(Color.White) // Todo: 색상 변경
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ProfileSection(
            profileImage = profileImage,
            name = name,
            location = location,
            distance = distance,
            modifier = Modifier,
        )

        if (itemCount > 0) {
            ProfileChip(
                itemCount = itemCount,
                modifier = Modifier,
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
    ) {
        UrlImage(
            url = profileImage,
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape),
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = name,
                style = TextStyle(
                    // Todo: 타이포 변경
                    fontSize = 18.sp,
                    lineHeight = 27.sp,
                    fontWeight = FontWeight(600),
                ),
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {

                Text(
                    text = location,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 19.6.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF757E8C),
                    )
                )

                Box(
                    modifier = Modifier
                        .background(
                            color = Color.Gray, // Todo: 색상 변경
                            shape = CircleShape,
                        )
                        .size(3.dp)
                )

                Text(
                    text = "${"%.1f".format(distance)}km",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 19.6.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF757E8C),
                    )
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
                color = Color.LightGray,
                shape = RoundedCornerShape(6.dp),
            )
            .widthIn(min = 61.dp)
            .padding(vertical = 4.dp, horizontal = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "${itemCount}",
            color = Color.Blue, // Todo: 색상 적용
            style = TextStyle(
                // Todo: 타이포 적용
                fontSize = 12.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF757E8C),
            ),
        )
        Text(
            text = "건 진행",
            style = TextStyle(
                // Todo: 타이포 적용
                fontSize = 12.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF757E8C),
            )
        )
    }
}

@Preview
@Composable
private fun DesignerProfilePreview() {
    Column() {
        // Todo: 테마 적용
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

//        Spacer(modifier = Modifier.height(10.dp))
//
//        DesignerProfile(
//            profileImage = "",
//            name = "승환임둥캬캬캬캬승환임둥캬캬캬캬승환임둥캬캬캬캬",
//            location = "경기 고양시",
//            distance = 11.6f,
//            itemCount = 77,
//        )
    }
}
