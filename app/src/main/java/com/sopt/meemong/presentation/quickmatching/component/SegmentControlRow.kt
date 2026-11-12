package com.sopt.meemong.presentation.quickmatching.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

@Composable
fun SegmentControlRow(
    onClick: (MatchingCategory) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MeemongTheme.colors.white)
            .padding(vertical = 8.dp, horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MatchingSegmentControl(
            onClick = onClick,
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_adjustments_24),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .border(
                    width = 1.dp,
                    color = MeemongTheme.colors.gray100,
                    shape = RoundedCornerShape(8.dp),
                )
                .padding(4.dp)
        )
    }
}

@Preview
@Composable
private fun SegmentControlRowPreview(){
    MeemongTheme {
        SegmentControlRow(
            onClick = {},
        )
    }
}
