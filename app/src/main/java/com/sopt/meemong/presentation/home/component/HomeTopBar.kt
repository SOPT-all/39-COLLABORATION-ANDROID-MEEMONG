package com.sopt.meemong.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

@Composable
fun HomeTopBar(
    onSearchClick: () -> Unit,
    onNotificationClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(MeemongTheme.colors.white)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(com.sopt.meemong.R.drawable.img_meemong_logo),
            contentDescription = "Meemong",
            modifier = Modifier
                .width(108.dp)
                .height(28.dp),
        )

        Spacer(modifier = Modifier.weight(1f))

        TopBarIcon(
            iconRes = com.sopt.meemong.R.drawable.ic_search_24,
            contentDescription = "검색",
            onClick = onSearchClick,
        )

        TopBarIcon(
            iconRes = com.sopt.meemong.R.drawable.ic_notification_24,
            contentDescription = "알림",
            onClick = onNotificationClick,
        )
    }
}

@Composable
private fun TopBarIcon(
    iconRes: Int,
    contentDescription: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(44.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = contentDescription,
            modifier = Modifier.size(24.dp),
            tint = MeemongTheme.colors.black,
        )
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun HomeTopBarPreview() {
    MeemongTheme {
        HomeTopBar(
            onSearchClick = {},
            onNotificationClick = {},
        )
    }
}
