package com.sopt.meemong.presentation.quickmatching.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

enum class MatchingCategory(
    val label: String,
) {
    DESIGNER("디자이너"),
    MODEL("모델"),
}

@Composable
fun MatchingSegmentControl(
    onClick: (MatchingCategory) -> Unit,
    modifier: Modifier = Modifier,
    currentCategory: MatchingCategory = MatchingCategory.DESIGNER,
) {
    Box(
        modifier = modifier
            .background(
                color = MeemongTheme.colors.white,
                shape = CircleShape,
            )
            .border(
                width = 1.dp,
                color = MeemongTheme.colors.gray100,
                shape = CircleShape,
            )
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier.width(IntrinsicSize.Max),
        ) {
            MatchingCategory.entries.forEach { category ->
                Text(
                    text = category.label,
                    style = MeemongTheme.typography.body2.sb14,
                    color = if (currentCategory == category) MeemongTheme.colors.white else MeemongTheme.colors.gray500,
                    modifier = Modifier
                        .weight(1f)
                        .clip(shape = CircleShape)
                        .background(
                            color = if (currentCategory == category) MeemongTheme.colors.gray800 else MeemongTheme.colors.white,
                            shape = CircleShape,
                        )
                        .clickable(
                            role = Role.Tab,
                            onClick = { onClick(category) },
                        )
                        .padding(vertical = 4.dp, horizontal = 10.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MatchingSegmentControlPreview() {
    MeemongTheme {
        var selectedCategory by rememberSaveable { mutableStateOf(MatchingCategory.DESIGNER) }

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            MatchingSegmentControl(
                onClick = { selectedCategory = it },
                currentCategory = selectedCategory,
            )

            MatchingSegmentControl(
                onClick = {},
                currentCategory = MatchingCategory.MODEL,
            )
        }
    }
}
