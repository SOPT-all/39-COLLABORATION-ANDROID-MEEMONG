package com.sopt.meemong.presentation.matchingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

enum class PriceType(
    val label: String,
) {
    REVIEW("리뷰 특가"),
    FREE("무료 시술"),
    NEGOTIABLE("재료비 발생")
}

@Composable
fun PriceTypeChip(
    label: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = label,
        color = MeemongTheme.colors.meemongBlue,
        modifier = modifier
            .background(
                color = MeemongTheme.colors.background,
                shape = RoundedCornerShape(6.dp),
            )
            .padding(vertical = 2.dp, horizontal = 6.dp)
    )
}

@Preview
@Composable
private fun PriceTypeChipPreview() {
    MeemongTheme {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            PriceType.entries.forEach { type ->
                PriceTypeChip(
                    label = type.label
                )
            }
        }
    }
}
