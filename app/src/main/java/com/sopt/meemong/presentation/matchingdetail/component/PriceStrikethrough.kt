package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.common.extensions.toPriceFormat
import com.sopt.meemong.core.designsystem.theme.MeemongTheme


@Composable
fun PriceStrikethrough(
    price: Int,
    modifier: Modifier = Modifier,
) {
    val textColor = MeemongTheme.colors.gray500

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier.wrapContentWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = price.toPriceFormat(),
                style = MeemongTheme.typography.body1.r16,
                color = textColor,
            )

            Text(
                text = "원",
                style = MeemongTheme.typography.body1.r16,
                color = textColor,
            )
        }

        Canvas(Modifier.matchParentSize()) {
            drawLine(
                color = textColor,
                start = Offset(0f, size.height / 2),
                end = Offset(size.width, size.height / 2),
                strokeWidth = 2.dp.toPx(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PriceStrikethroughPreview() {
    MeemongTheme {
        PriceStrikethrough(
            price = 35_000,
        )
    }
}
