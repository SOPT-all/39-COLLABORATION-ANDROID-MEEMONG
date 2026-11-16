package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.component.UrlImage
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.presentation.matchingdetail.MatchingDetailUiState

@Composable
fun ShopSection(
    shopName: String,
    shopAddress: String,
    shopImageUrls: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MeemongTheme.colors.white)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = "매장 정보",
                style = MeemongTheme.typography.body1.sb16,
                color = MeemongTheme.colors.black,
            )

            Text(
                text = shopName,
                style = MeemongTheme.typography.body2.m14,
                color = MeemongTheme.colors.gray700,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MeemongTheme.colors.white,
                    shape = RoundedCornerShape(8.dp),
                )
                .border(
                    width = 1.dp,
                    color = MeemongTheme.colors.gray200,
                    shape = RoundedCornerShape(8.dp),
                )
                .padding(13.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = shopAddress,
                style = MeemongTheme.typography.body2.r14,
                color = MeemongTheme.colors.black,
                modifier = Modifier.weight(1f),
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_copy_24),
                contentDescription = null,
                tint = MeemongTheme.colors.gray700,
                modifier = Modifier.size(24.dp),
            )
        }

        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.img_map),
            contentDescription = "지도",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(343f / 193f)
                .clip(shape = RoundedCornerShape(14.dp)),
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            shopImageUrls.forEach { url ->
                UrlImage(
                    url = url,
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .clip(shape = RoundedCornerShape(6.dp)),
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}

@Preview
@Composable
private fun ShopSectionPreview() {
    MeemongTheme {
        val dummy = MatchingDetailUiState.dummy

        ShopSection(
            shopName = dummy.serviceInfo.shopName,
            shopAddress = dummy.detailInfo.shopAddress,
            shopImageUrls = dummy.detailInfo.shopImageUrls,
        )
    }
}
