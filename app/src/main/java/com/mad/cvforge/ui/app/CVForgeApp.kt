package com.mad.cvforge.ui.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import com.mad.cvforge.navigation.CVForgeNavHost
import com.mad.cvforge.navigation.TopLevelDestination
import com.mad.cvforge.utils.DevicePosture
import com.mad.cvforge.utils.isTopLevelDestinationInHierarchy
import mad.core.designsystem.component.CVForgeTopAppBar
import mad.core.designsystem.component.NavRailFAB
import mad.core.designsystem.icon.CVForgeIcons
import mad.feature.premium.PremiumDialog


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CVForgeApp(
    windowSize: WindowSizeClass,
    foldingDevicePosture: DevicePosture,
    appState: CVForgeAppState = rememberCVForgeAppState(
        windowSizeClass = windowSize,
        foldingDevicePosture = foldingDevicePosture,
    ),
) {
    var isPreviewEnabled by remember {
        mutableStateOf(false)
    }

    var showPremiumDialog by rememberSaveable {
        mutableStateOf(false)
    }
    val snackbarHostState = remember { SnackbarHostState() }
    Surface {
        if (showPremiumDialog) {
            PremiumDialog(
                onDismiss = { showPremiumDialog = false },
            )
        }
        Scaffold(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            snackbarHost = { SnackbarHost(snackbarHostState) },
            bottomBar = {
                AnimatedVisibility(visible = appState.shouldShowBottomBar()) {
                    CVForgeBottomBar(
                        destinations = appState.topLevelDestinations,
                        onNavigateToDestination = appState::navigateToTopLevelDestination,
                        currentDestination = appState.currentDestination,
                        modifier = Modifier.testTag("CvForgeBottomBar"),
                    )
                }
            }
        ) { padding ->
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                AnimatedVisibility(visible = appState.shouldShowNavRail()) {
                    CVForgeNavRail(
                        destinations = appState.topLevelDestinations,
                        onNavigateToDestination = appState::navigateToTopLevelDestination,
                        currentDestination = appState.currentDestination,
                        modifier = Modifier.safeDrawingPadding(),
                        onFabClick = { isPreviewEnabled = !isPreviewEnabled }
                    )
                }

                Column(Modifier.fillMaxSize()) {
                    CVForgeTopAppBar(
                        titleRes = "CV Forge",
                        navigationIcon = CVForgeIcons.Person,
                        navigationIconContentDescription = "Account",
                        actionIcon = CVForgeIcons.Premium,
                        actionIconContentDescription = "Premium",
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = Color.Transparent,
                        ),
                        onActionClick = { showPremiumDialog = true },
                        onNavigationClick = { appState.navigateToProfile() },
                    )

                    CVForgeNavHost(appState = appState,
                        isPreviewEnabled = isPreviewEnabled,
                        onShowSnackbar = { message, action ->
                            snackbarHostState.showSnackbar(
                                message = message,
                                actionLabel = action,
                                duration = SnackbarDuration.Short,
                            ) == SnackbarResult.ActionPerformed
                        })
                }
            }
        }
    }
}


@Composable
private fun CVForgeBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            NavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        imageVector = destination.unselectedIcon,
                        contentDescription = null,
                    )
                },
                label = { Text(stringResource(destination.iconTextId)) },
            )
        }
    }
}

@Composable
private fun CVForgeNavRail(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    onFabClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationRail(
        modifier = modifier,
        header = { NavRailFAB(onFabClick = onFabClick) }
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            NavigationRailItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        imageVector = destination.unselectedIcon,
                        contentDescription = null,
                    )
                },
                label = { Text(stringResource(destination.iconTextId)) },
            )
        }
    }
}

