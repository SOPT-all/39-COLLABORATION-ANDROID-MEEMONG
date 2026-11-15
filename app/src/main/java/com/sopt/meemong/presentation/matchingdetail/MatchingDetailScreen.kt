package com.sopt.meemong.presentation.matchingdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.core.di.ViewModelFactory

@Composable
fun MatchingDetailRoute(
    modifier: Modifier = Modifier,
    viewModel: MatchingDetailViewModel = viewModel(factory = ViewModelFactory()),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MatchingDetailScreen(
        uiState = uiState,
        modifier = modifier,
    )
}

@Composable
private fun MatchingDetailScreen(
    uiState: MatchingDetailUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "상세페이지",
            fontSize = 30.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MatchingDetailScreenPreview() {
    MeemongTheme {
        MatchingDetailScreen(
            uiState = MatchingDetailUiState(),
        )
    }
}
