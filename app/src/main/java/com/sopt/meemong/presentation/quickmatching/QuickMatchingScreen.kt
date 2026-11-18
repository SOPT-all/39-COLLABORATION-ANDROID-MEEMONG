package com.sopt.meemong.presentation.quickmatching

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.meemong.core.designsystem.component.MeemongFloatingMenu
import com.sopt.meemong.core.designsystem.component.MeemongFloatingMenuType
import com.sopt.meemong.core.designsystem.component.MeemongTopBar
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.presentation.quickmatching.component.MatchingCategory
import com.sopt.meemong.presentation.quickmatching.component.QuickMatchingBanner
import com.sopt.meemong.presentation.quickmatching.component.QuickMatchingGeneralSection
import com.sopt.meemong.presentation.quickmatching.component.QuickMatchingRecommendedSection
import com.sopt.meemong.presentation.quickmatching.component.SegmentControlRow
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.meemong.core.di.ViewModelFactory

@Composable
fun QuickMatchingRoute(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    viewModel: QuickMatchingViewModel = viewModel(factory = ViewModelFactory()),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    QuickMatchingScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onCategoryClick = viewModel::onCategoryClick,
        onPostClick = {},
        onLikeChange = viewModel::onLikeChange,
        onMoreClick = {},
        modifier = modifier,
    )
}

@Composable
private fun QuickMatchingScreen(
    uiState: QuickMatchingUiState,
    onBackClick: () -> Unit,
    onCategoryClick: (MatchingCategory) -> Unit,
    onPostClick: (Long) -> Unit,
    onLikeChange: (Long, Boolean) -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isFloatingMenuExpanded by rememberSaveable { mutableStateOf(false) }

    val (recommendedPosts, generalPosts) = when (uiState.selectedCategory) {
        MatchingCategory.DESIGNER ->
            uiState.designerRecommendedPosts to uiState.designerGeneralPosts

        MatchingCategory.MODEL ->
            uiState.modelRecommendedPosts to uiState.modelGeneralPosts
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MeemongTheme.colors.white),
    ) {
        MeemongTopBar(
            title = "빠른 매칭",
            onBackClick = onBackClick,
        )

        SegmentControlRow(
            currentCategory = uiState.selectedCategory,
            onClick = onCategoryClick,
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(MeemongTheme.colors.gray100),
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(top = 20.dp, bottom = 128.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    QuickMatchingRecommendedSection(
                        posts = recommendedPosts,
                        onPostClick = onPostClick,
                        onLikeChange = onLikeChange,
                        onMoreClick = onMoreClick,
                        modifier = Modifier.padding(horizontal = 20.dp),
                    )
                }

                item {
                    QuickMatchingBanner()
                }

                item {
                    QuickMatchingGeneralSection(
                        posts = generalPosts,
                        onPostClick = onPostClick,
                        onLikeChange = onLikeChange,
                        modifier = Modifier.padding(horizontal = 20.dp),
                    )
                }
            }

            MeemongFloatingMenu(
                type = MeemongFloatingMenuType.QUICK_MATCHING,
                isExpanded = isFloatingMenuExpanded,
                onExpandedChange = { isFloatingMenuExpanded = it },
                onItemClick = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 20.dp, bottom = 116.dp),
            )
        }
    }
}

@Preview(name = "디자이너 탭", showBackground = true, widthDp = 375, heightDp = 812)
@Composable
private fun QuickMatchingDesignerPreview() {
    QuickMatchingPreview(category = MatchingCategory.DESIGNER)
}

@Preview(name = "모델 탭", showBackground = true, widthDp = 375, heightDp = 812)
@Composable
private fun QuickMatchingModelPreview() {
    QuickMatchingPreview(category = MatchingCategory.MODEL)
}

@Composable
private fun QuickMatchingPreview(category: MatchingCategory) {
    MeemongTheme {
        QuickMatchingScreen(
            uiState = QuickMatchingUiState.dummy.copy(selectedCategory = category),
            onBackClick = {},
            onCategoryClick = {},
            onPostClick = {},
            onLikeChange = { _, _ -> },
            onMoreClick = {},
        )
    }
}
