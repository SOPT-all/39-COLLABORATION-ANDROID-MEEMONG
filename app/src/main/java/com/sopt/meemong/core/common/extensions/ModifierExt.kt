package com.sopt.meemong.core.common.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

/**
 * 리플 효과 없이 클릭 가능하게 만드는 Modifier
 *
 * 기본 리플 효과를 제거합니다.
 *
 * @param onClick 클릭 시 실행될 콜백
 * @param enabled 버튼 활성 여부
 */
@Composable
fun Modifier.noRippleClickable(
    onClick: () -> Unit,
    enabled: Boolean = true,
): Modifier =
    this.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick,
        enabled = enabled,
    )
