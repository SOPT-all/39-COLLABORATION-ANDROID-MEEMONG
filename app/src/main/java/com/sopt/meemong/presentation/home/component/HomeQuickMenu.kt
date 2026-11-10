package com.sopt.meemong.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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

enum class HomeQuickMenuItem(
    @DrawableRes val iconRes: Int,
    val label: String,
) {
    REVIEW(R.drawable.ic_quick_review_32, "리뷰특가"),
    FREE(R.drawable.ic_quick_free_32, "무료시술"),
    PARTNER(R.drawable.ic_quick_partner_32, "안심매칭"),
    CONSULTATION(R.drawable.ic_quick_consultation_32, "컨설팅"),
    QUICK_MATCHING(R.drawable.ic_quick_matching_32, "빠른매칭"),
    RANK(R.drawable.ic_quick_rank_32,"상담랭킹"),
}

@Composable
fun HomeQuickMenu(
    onItemClick: (HomeQuickMenuItem) ->Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MeemongTheme.colors.white)
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        HomeQuickMenuItem.entries.chunked(3).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(56.dp, Alignment.CenterHorizontally),
            ) {
                rowItems.forEach { item ->
                    QuickMenuItem(
                        item = item,
                        onClick = { onItemClick(item) },
                    )
                }
            }
        }
    }
}

@Composable
private fun QuickMenuItem(
    item: HomeQuickMenuItem,
    onClick: () -> Unit,
) {
    val boxShape = RoundedCornerShape(16.dp)

    Column(
        modifier = Modifier
            .width(56.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(boxShape)
                .background(MeemongTheme.colors.gray50)
                .border(width = 1.dp, color = MeemongTheme.colors.gray100, shape = boxShape),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(item.iconRes),
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
        }

        Text(
            text = item.label,
            color = MeemongTheme.colors.gray900,
            style = MeemongTheme.typography.body2.r14,
            maxLines = 1,
            softWrap = false,
        )
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun HomeQuickMenuPreview() {
    MeemongTheme{
        HomeQuickMenu(onItemClick = {})
    }
}
