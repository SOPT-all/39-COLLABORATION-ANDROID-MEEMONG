package com.sopt.meemong.presentation.quickmatching

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.meemong.core.designsystem.theme.MeemongTheme
import com.sopt.meemong.core.di.ViewModelFactory

@Composable
fun QuickMatchingRoute(
    modifier: Modifier = Modifier
) {
    QuickMatchingScreen(
        modifier = modifier
    )
}

@Composable
private fun QuickMatchingScreen(
    modifier: Modifier = Modifier,
    viewModel: QuickMatchingViewModel = viewModel(factory = ViewModelFactory()),
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "빠른 매칭",
            fontSize = 30.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuickMatchingScreenPreview() {
    MeemongTheme {
        QuickMatchingScreen()
    }
}
