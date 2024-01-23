package com.mad.cvforge.ui.app


import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.mad.cvforge.navigation.TopLevelDestination
import com.mad.cvforge.utils.AdaptiveLayout
import com.mad.cvforge.utils.DevicePosture
import mad.feature.coverletter.navigation.coverLetterRoute
import mad.feature.home.navigation.homeRoute
import mad.feature.profile.navigation.navigateToProfile
import mad.feature.profile.navigation.profileRoute
import mad.feature.resume.navigation.resumeRoute

@Composable
fun rememberCVForgeAppState(
    windowSizeClass: WindowSizeClass,
    foldingDevicePosture: DevicePosture,
    navController: NavHostController = rememberNavController(),
): CVForgeAppState {
    return remember(
        windowSizeClass,
        foldingDevicePosture,
        navController,
    ) {
        CVForgeAppState(
            navController,
            AdaptiveLayout(windowSizeClass, foldingDevicePosture)
        )
    }
}


@Stable
class CVForgeAppState(
    val navController: NavHostController,
    private val adaptiveLayout: AdaptiveLayout
) {
    fun navigateToProfile() {
        navController.navigateToProfile()
    }

    @Composable
    fun shouldShowFAB() = adaptiveLayout.isOnePageLayout() and isRouteWithNavigation()
    @Composable
    fun shouldShowBottomBar() = adaptiveLayout.shouldShowBottomBar() and isRouteWithNavigation()
    @Composable
    fun shouldShowNavRail() = adaptiveLayout.shouldShowNavRail() and isRouteWithNavigation()

    fun isOnePageLayout() = adaptiveLayout.isOnePageLayout()
    fun isTwoPageLayout() = adaptiveLayout.isTwoPageLayout()

    @Composable
    private fun isRouteWithNavigation(): Boolean {
        val currentRoute = currentDestination?.route
        return (currentRoute == resumeRoute) or (currentRoute == coverLetterRoute)
    }

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            homeRoute -> TopLevelDestination.FORGE
            profileRoute -> TopLevelDestination.PROFILE
            else -> null
        }

    /**
     * Map of top level destinations to be used in the TopBar, BottomBar and NavRail. The key is the
     * route.
     */
    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()


    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }

}
