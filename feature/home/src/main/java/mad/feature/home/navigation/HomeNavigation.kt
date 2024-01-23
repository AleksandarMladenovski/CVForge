package mad.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import mad.feature.home.HomeRoute

const val homeRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(homeRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    onResumeSelect: () -> Unit,
    onCoverLetterSelect: () -> Unit,
) {
    composable(route = homeRoute) {
        HomeRoute(
            onResumeSelect = onResumeSelect,
            onCoverLetterSelect= onCoverLetterSelect
        )
    }
}