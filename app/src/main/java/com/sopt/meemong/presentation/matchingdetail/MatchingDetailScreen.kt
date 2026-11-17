package com.sopt.meemong.presentation.matchingdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.meemong.R
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.data.matchingdetail.model.TabType
import com.sopt.meemong.presentation.matchingdetail.component.ContentSection
import com.sopt.meemong.presentation.matchingdetail.component.DesignerProfile
import com.sopt.meemong.presentation.matchingdetail.component.DetailTab
import com.sopt.meemong.presentation.matchingdetail.component.ImageCarousel
import com.sopt.meemong.presentation.matchingdetail.component.ReservationButton
import com.sopt.meemong.presentation.matchingdetail.component.ServiceInfoCard

@Composable
fun MatchingDetailRoute(
    viewModel: MatchingDetailViewModel,
    navigateToBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MatchingDetailScreen(
        state = uiState,
        onBackClick = navigateToBack,
        onLikeClick = viewModel::onLikeClick,
        onTabClick = viewModel::onTabClick,
        modifier = modifier,
    )
}

@Composable
private fun MatchingDetailScreen(
    state: MatchingDetailUiState,
    onBackClick: () -> Unit,
    onLikeClick: () -> Unit,
    onTabClick: (TabType) -> Unit,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()

    val designerProfileInfo = state.designerProfileInfo
    val serviceInfo = state.serviceInfo
    val detailInfo = state.detailInfo

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MeemongTheme.colors.white),
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier.weight(1f),
        ) {
            item {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ImageCarousel(
                        urlList = state.postImageUrls,
                    )

                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(start = 6.dp, top = 64.dp)
                            .size(44.dp),
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_back_24),
                            contentDescription = "뒤로가기",
                            tint = if (state.postImageUrls.isEmpty()) MeemongTheme.colors.black else MeemongTheme.colors.white,
                            modifier = Modifier.size(24.dp),
                        )
                    }
                }

                DesignerProfile(
                    profileImage = designerProfileInfo.designerProfileImageUrl,
                    name = designerProfileInfo.designerName,
                    location = designerProfileInfo.region,
                    itemCount = designerProfileInfo.completedTreatmentCount,
                )

                ServiceInfoCard(
                    serviceInfo = serviceInfo,
                    onLikeClick = onLikeClick,
                )

                DetailTab(
                    currentTab = state.currentTab,
                    onTabClick = onTabClick,
                )

                ContentSection(
                    currentTab = state.currentTab,
                    content = detailInfo.content,
                    portfolioImageUrls = detailInfo.portfolioImageUrls,
                    shopName = serviceInfo.shopName,
                    shopAddress = detailInfo.shopAddress,
                    shopImageUrls = detailInfo.shopImageUrls,
                )
            }

        }

        ReservationButton(
            onClick = {},
            isEnabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MeemongTheme.colors.white)
                .navigationBarsPadding()
                .padding(horizontal = 16.dp, vertical = 24.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MatchingDetailScreenPreview() {
    MeemongTheme {
        MatchingDetailScreen(
            state = MatchingDetailUiState.dummy,
            onBackClick = {},
            onLikeClick = {},
            onTabClick = {},
        )
    }
}
