package com.sopt.meemong.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.R
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import kotlin.jvm.Throws

@Composable
fun HomeConsultingCard(
    title: String,
    description: String,
    timeAgo: String,
    commentCount: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(6.dp)

    Column(
        modifier = Modifier
            .width(189.dp)
            .height(125.dp)
            .clip(shape)
            .background(MeemongTheme.colors.white)
            .border(width = 1.dp, color = MeemongTheme.colors.gray300, shape = shape)
            .clickable(onClick = onClick)
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = title,
                color = MeemongTheme.colors.black,
                style = MeemongTheme.typography.body1.sb16,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = description,
                color = MeemongTheme.colors.gray600,
                style = MeemongTheme.typography.body2.r14,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = timeAgo,
                color = MeemongTheme.colors.gray600,
                style = MeemongTheme.typography.caption1.r12,
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Icon(
                    painter = painterResource(com.sopt.meemong.R.drawable.ic_comment_16),
                    contentDescription = "댓글",
                    modifier = Modifier.size(16.dp),
                    tint = MeemongTheme.colors.gray600,
                )

                Text(
                    text = commentCount.toString(),
                    color = MeemongTheme.colors.gray600,
                    style = MeemongTheme.typography.body2.sb14,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HmeconsultuingCardPreview() {
    MeemongTheme {
        HomeConsultingCard(
            title = "예쁜 브라운/베이지 염색 받고 싶어요",
            description = "18만원대 이내로 쿨톤 브라운 염색하고 싶습니다!",
            timeAgo = "2일 전",
            commentCount = 12,
            onClick = {},
        )
    }
}
