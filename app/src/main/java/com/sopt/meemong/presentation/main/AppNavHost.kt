package com.sopt.meemong.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sopt.meemong.MeemongApplication
import com.sopt.meemong.core.common.navigation.Home
import com.sopt.meemong.core.common.navigation.MatchingDetail
import com.sopt.meemong.core.common.navigation.QuickMatching
import com.sopt.meemong.di.ViewModelFactory
import com.sopt.meemong.presentation.home.HomeRoute
import com.sopt.meemong.presentation.home.HomeViewModel
import com.sopt.meemong.presentation.matchingdetail.MatchingDetailRoute
import com.sopt.meemong.presentation.matchingdetail.MatchingDetailViewModel
import com.sopt.meemong.presentation.quickmatching.QuickMatchingRoute
import com.sopt.meemong.presentation.quickmatching.QuickMatchingViewModel

@Composable
fun AppNavHost(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val application = LocalContext.current.applicationContext as MeemongApplication
    val factory = remember(application) {
        ViewModelFactory(application.container)
    }

    NavHost(
        navController = navController,
        startDestination = Home,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        modifier = modifier,
    ) {
        composable<Home> {
            val viewModel: HomeViewModel = viewModel(factory = factory)

            HomeRoute(
                viewModel = viewModel,
                navigateToQuickMatching = { navController.navigate(QuickMatching) },
                navigateToMatchingDetail = { navController.navigate(MatchingDetail) },
                modifier = Modifier
                    .padding(paddingValues)
                    .consumeWindowInsets(paddingValues),
            )
        }

        composable<QuickMatching> {
            val viewModel: QuickMatchingViewModel = viewModel(factory = factory)

            QuickMatchingRoute(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onPostClick = {
                    navController.navigate(MatchingDetail) {
                        launchSingleTop = true
                    }
                },
                modifier = Modifier
                    .padding(paddingValues)
                    .consumeWindowInsets(paddingValues),
            )
        }

        composable<MatchingDetail> {
            val viewModel: MatchingDetailViewModel = viewModel(factory = factory)

            MatchingDetailRoute(
                viewModel = viewModel,
                navigateToBack = { navController.popBackStack() },
            )
        }
    }
}
