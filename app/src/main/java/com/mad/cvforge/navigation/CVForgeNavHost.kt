package com.mad.cvforge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.mad.cvforge.ui.app.CVForgeAppState
import mad.feature.coverletter.navigation.coverLetterScreen
import mad.feature.coverletter.navigation.navigateToCoverLetter
import mad.feature.home.navigation.homeRoute
import mad.feature.home.navigation.homeScreen
import mad.feature.preview.navigation.navigateToPreview
import mad.feature.preview.navigation.previewScreen
import mad.feature.profile.navigation.profileScreen
import mad.feature.resume.navigation.navigateToResume
import mad.feature.resume.navigation.resumeScreen

@Composable
fun CVForgeNavHost(
    appState: CVForgeAppState,
    isPreviewEnabled: Boolean=false,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
    startDestination: String = homeRoute,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen(
            onResumeSelect = navController::navigateToResume,
            onCoverLetterSelect = navController::navigateToCoverLetter
        )
        profileScreen()
        resumeScreen(
            isOnePageLayout = appState.isOnePageLayout(),
            isPreviewEnabled = isPreviewEnabled,
            onNavigateToPreview = navController::navigateToPreview)
        coverLetterScreen()
        previewScreen()
    }
}