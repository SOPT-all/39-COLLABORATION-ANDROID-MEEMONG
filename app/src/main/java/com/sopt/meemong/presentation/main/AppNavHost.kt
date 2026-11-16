package com.sopt.meemong.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sopt.meemong.core.common.navigation.Home
import com.sopt.meemong.core.common.navigation.MatchingDetail
import com.sopt.meemong.core.common.navigation.QuickMatching
import com.sopt.meemong.presentation.home.HomeRoute
import com.sopt.meemong.presentation.matchingdetail.MatchingDetailRoute
import com.sopt.meemong.presentation.quickmatching.QuickMatchingRoute

@Composable
fun AppNavHost(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
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
            HomeRoute(
                modifier = Modifier
                    .padding(paddingValues)
                    .consumeWindowInsets(paddingValues),
            )
        }

        composable<QuickMatching> {
            QuickMatchingRoute(
                modifier = Modifier
                    .padding(paddingValues)
                    .consumeWindowInsets(paddingValues),
            )
        }

        composable<MatchingDetail> {
            MatchingDetailRoute(
                navigateToBack = { navController.popBackStack() },
            )
        }
    }
}
