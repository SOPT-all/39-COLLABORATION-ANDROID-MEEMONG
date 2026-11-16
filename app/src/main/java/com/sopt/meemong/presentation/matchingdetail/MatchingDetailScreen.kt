package com.sopt.meemong.presentation.matchingdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.core.di.ViewModelFactory
import com.sopt.meemong.data.matchingdetail.model.TabType
import com.sopt.meemong.presentation.matchingdetail.component.ContentSection
import com.sopt.meemong.presentation.matchingdetail.component.DesignerProfile
import com.sopt.meemong.presentation.matchingdetail.component.DetailTab
import com.sopt.meemong.presentation.matchingdetail.component.ImageCarousel
import com.sopt.meemong.presentation.matchingdetail.component.ReservationButton
import com.sopt.meemong.presentation.matchingdetail.component.ServiceInfoCard

@Composable
fun MatchingDetailRoute(
    modifier: Modifier = Modifier,
    viewModel: MatchingDetailViewModel = viewModel(factory = ViewModelFactory()),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MatchingDetailScreen(
        state = uiState,
        onBackClick = {},
        onLikeClick = {},
        modifier = modifier,
    )
}

@Composable
private fun MatchingDetailScreen(
    state: MatchingDetailUiState,
    onBackClick: () -> Unit,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()

    var currentTab by rememberSaveable() { mutableStateOf(TabType.CONTENT_DETAIL) }

    val designerProfileInfo = state.designerProfileInfo
    val serviceInfo = state.serviceInfo
    val detailInfo = state.detailInfo

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier.weight(1f),
        ) {
            item {
                ImageCarousel(
                    urlList = state.postImageUrls,
                    onBackClick = onBackClick
                )

                DesignerProfile(
                    profileImage = designerProfileInfo.designerProfileImageUrl,
                    name = designerProfileInfo.designerName,
                    location = designerProfileInfo.region,
                    distance = 11.6f,
                    itemCount = designerProfileInfo.completedTreatmentCount,
                )

                ServiceInfoCard(
                    serviceInfo = serviceInfo,
                    onLikeClick = onLikeClick,
                )

                DetailTab(
                    currentTab = currentTab,
                    onTabClick = { currentTab = it },
                )

                ContentSection(
                    currentTab = currentTab,
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
        )
    }
}
