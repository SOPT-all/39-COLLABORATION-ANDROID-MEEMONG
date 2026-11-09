package com.sopt.meemong.core.designsystem.component

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.theme.MeemongTheme

enum class MeemongFloatingMenuItem(
    val title: String,
    @param:DrawableRes val iconRes: Int,
) {
    QUICK_MATCHING(
        title = "빠른매칭",
        iconRes = R.drawable.ic_matching_14,
    ),
    SPONSORSHIP(
        title = "협찬신청",
        iconRes = R.drawable.ic_sponsorship_14,
    ),
    HAIR_CONSULTING(
        title = "헤어컨설팅",
        iconRes = R.drawable.ic_consultation_14,
    ),
    NORMAL_POST(
        title = "일반공고",
        iconRes = R.drawable.ic_announcement_14,
    ),
    RECOMMENDED_POST(
        title = "미몽추천",
        iconRes = R.drawable.ic_recommend_14,
    ),
}

enum class MeemongFloatingMenuType(
    val items: List<MeemongFloatingMenuItem>,
) {
    HOME(
        items = listOf(
            MeemongFloatingMenuItem.QUICK_MATCHING,
            MeemongFloatingMenuItem.SPONSORSHIP,
            MeemongFloatingMenuItem.HAIR_CONSULTING,
        ),
    ),
    QUICK_MATCHING(
        items = listOf(
            MeemongFloatingMenuItem.NORMAL_POST,
            MeemongFloatingMenuItem.RECOMMENDED_POST,
        ),
    ),
}

/**
 * 홈 및 빠른매칭 화면에서 사용하는 플로팅 메뉴입니다.
 *
 * 열림 상태는 호출부에서 관리합니다.
 * 항목을 선택하면 닫힘 이벤트를 전달한 뒤 선택 콜백을 호출합니다.
 * 실제 화면 이동과 화면 바깥 여백은 호출부에서 처리합니다.
 */

@Composable
fun MeemongFloatingMenu(
    type: MeemongFloatingMenuType,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onItemClick: (MeemongFloatingMenuItem) -> Unit,
    modifier: Modifier = Modifier,
) {

}

@Composable
private fun FloatingMenuPanel(
    items: List<MeemongFloatingMenuItem>,
    onItemClick: (MeemongFloatingMenuItem) -> Unit,
) {
    Column(
        modifier = Modifier
            .width(102.dp)
            .floatingMenuShadow(shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(MeemongTheme.colors.gray900)
    ) {
        items.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        role = Role.Button,
                        onClick = { onItemClick(item) }
                    )
                    .padding(
                        horizontal = 12.dp,
                        vertical = 10.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(item.iconRes),
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = MeemongTheme.colors.white
                )

                Text(
                    text = item.title,
                    color = MeemongTheme.colors.white,
                    style = MeemongTheme.typography.body2.m14,
                    maxLines = 1,
                    softWrap = false,
                )
            }
        }
    }
}

private fun Modifier.floatingMenuShadow(
    shape: Shape,
    spread: Dp = 0.dp,
): Modifier = dropShadow(
    shape = shape,
    shadow = Shadow(
        radius = 5.7.dp,
        spread = spread,
        color = Color.Black.copy(alpha = 0.5f),
        offset = DpOffset.Zero,
    ),
)
