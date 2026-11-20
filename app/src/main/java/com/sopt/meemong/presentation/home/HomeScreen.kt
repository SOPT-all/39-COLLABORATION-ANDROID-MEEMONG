package com.sopt.meemong.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.component.MeemongBottomBar
import com.sopt.meemong.core.designsystem.component.MeemongBottomTab
import com.sopt.meemong.core.designsystem.component.MeemongFloatingMenu
import com.sopt.meemong.core.designsystem.component.MeemongFloatingMenuType
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.presentation.home.component.HomeConsultingCardSection
import com.sopt.meemong.presentation.home.component.HomeDesignerCardSection
import com.sopt.meemong.presentation.home.component.HomeMatchingPostSection
import com.sopt.meemong.presentation.home.component.HomeProductSection
import com.sopt.meemong.presentation.home.component.HomeQuickMenu
import com.sopt.meemong.presentation.home.component.HomeQuickMenuItem
import com.sopt.meemong.presentation.home.component.HomeTopBar
import com.sopt.meemong.presentation.home.model.HomeMatchingPostItem

@Composable
fun HomeRoute(
    viewModel: HomeViewModel,
    navigateToQuickMatching: () -> Unit,
    navigateToMatchingDetail: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                HomeUiEffect.NavigateToQuickMatching -> navigateToQuickMatching()
                is HomeUiEffect.NavigateToMatchingDetail -> navigateToMatchingDetail(effect.postId)
            }
        }
    }

    HomeScreen(
        uiState = uiState,
        onQuickMenuClick = viewModel::onQuickMenuClick,
        onMatchingPostClick = viewModel::onMatchingPostClick,
        onMatchingPostLikeChange = viewModel::onMatchingPostLikeChange,
        onMatchingPostMoreClick = viewModel::onMatchingPostMoreClick,
        modifier = modifier,
    )
}

@Composable
private fun HomeScreen(
    uiState: HomeUiState,
    onQuickMenuClick: (HomeQuickMenuItem) -> Unit,
    onMatchingPostClick: (HomeMatchingPostItem) -> Unit,
    onMatchingPostLikeChange: (HomeMatchingPostItem, Boolean) -> Unit,
    onMatchingPostMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isFloatingMenuExpanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MeemongTheme.colors.white),
    ) {
        HomeTopBar(
            onSearchClick = {},
            onNotificationClick = {},
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    // 피그마 기준: 상단바 아래 16, 마지막 섹션 아래 55
                    .padding(top = 16.dp, bottom = 55.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                Image(
                    bitmap = ImageBitmap.imageResource(R.drawable.img_home_banner),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .aspectRatio(335f / 80f),
                )

                HomeQuickMenu(
                    onItemClick = onQuickMenuClick,
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(32.dp),
                ) {
                    uiState.designerSections.forEach { section ->
                        HomeDesignerCardSection(
                            title = section.title,
                            items = section.items,
                            onMoreClick = {},
                        )
                    }

                    HomeMatchingPostSection(
                        items = uiState.matchingPosts,
                        onItemClick = onMatchingPostClick,
                        onLikeChange = onMatchingPostLikeChange,
                        onMoreClick = onMatchingPostMoreClick,
                    )

                    HomeProductSection(
                        title = uiState.productTitle,
                        description = uiState.productDescription,
                        items = uiState.products,
                        onItemClick = {},
                        onMoreClick = {},
                    )

                    HomeConsultingCardSection(
                        items = uiState.consultings,
                        onItemClick = {},
                        onMoreClick = {},
                    )
                }
            }

            MeemongFloatingMenu(
                type = MeemongFloatingMenuType.HOME,
                isExpanded = isFloatingMenuExpanded,
                onExpandedChange = { isFloatingMenuExpanded = it },
                onItemClick = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 20.dp, bottom = 22.dp),
            )
        }

        MeemongBottomBar(
            selectedTab = MeemongBottomTab.HOME,
            onTabClick = {},
        )
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
private fun HomeScreenPreview() {
    MeemongTheme {
        HomeScreen(
            uiState = HomeUiState.dummy,
            onQuickMenuClick = {},
            onMatchingPostClick = {},
            onMatchingPostLikeChange = { _, _ -> },
            onMatchingPostMoreClick = {},
        )
    }
}
