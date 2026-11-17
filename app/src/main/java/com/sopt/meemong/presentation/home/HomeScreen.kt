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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.component.MeemongBottomBar
import com.sopt.meemong.core.designsystem.component.MeemongBottomTab
import com.sopt.meemong.core.designsystem.component.MeemongFloatingMenu
import com.sopt.meemong.core.designsystem.component.MeemongFloatingMenuItem
import com.sopt.meemong.core.designsystem.component.MeemongFloatingMenuType
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.core.di.ViewModelFactory
import com.sopt.meemong.presentation.home.component.HomeConsultingCardSection
import com.sopt.meemong.presentation.home.component.HomeDesignerCardSection
import com.sopt.meemong.presentation.home.component.HomeDesignerItem
import com.sopt.meemong.presentation.home.component.HomeMatchingPostItem
import com.sopt.meemong.presentation.home.component.HomeMatchingPostSection
import com.sopt.meemong.presentation.home.component.HomeProductSection
import com.sopt.meemong.presentation.home.component.HomeQuickMenu
import com.sopt.meemong.presentation.home.component.HomeQuickMenuItem
import com.sopt.meemong.presentation.home.component.HomeTopBar

@Composable
fun HomeRoute(
    navigateToQuickMatching: () -> Unit,
    navigateToMatchingDetail: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = ViewModelFactory()),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                HomeUiEffect.NavigateToQuickMatching -> navigateToQuickMatching()
                HomeUiEffect.NavigateToMatchingDetail -> navigateToMatchingDetail()
            }
        }
    }

    HomeScreen(
        uiState = uiState,
        onQuickMenuClick = viewModel::onQuickMenuClick,
        onDesignerClick = viewModel::onDesignerClick,
        onMatchingPostLikeChange = viewModel::onMatchingPostLikeChange,
        onMatchingPostMoreClick = viewModel::onMatchingPostMoreClick,
        onFloatingMenuItemClick = viewModel::onFloatingMenuItemClick,
        modifier = modifier,
    )
}

@Composable
private fun HomeScreen(
    uiState: HomeUiState,
    onQuickMenuClick: (HomeQuickMenuItem) -> Unit,
    onDesignerClick: (HomeDesignerItem) -> Unit,
    onMatchingPostLikeChange: (HomeMatchingPostItem, Boolean) -> Unit,
    onMatchingPostMoreClick: () -> Unit,
    onFloatingMenuItemClick: (MeemongFloatingMenuItem) -> Unit,
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
                    painter = painterResource(R.drawable.img_home_banner),
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
                            onItemClick = onDesignerClick,
                            onMoreClick = {},
                        )
                    }

                    HomeMatchingPostSection(
                        items = uiState.matchingPosts,
                        onItemClick = {},
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
                onItemClick = onFloatingMenuItemClick,
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
            onDesignerClick = {},
            onMatchingPostLikeChange = { _, _ -> },
            onMatchingPostMoreClick = {},
            onFloatingMenuItemClick = {},
        )
    }
}
