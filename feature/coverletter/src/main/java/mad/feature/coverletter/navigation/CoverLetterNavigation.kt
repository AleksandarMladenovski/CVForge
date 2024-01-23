package mad.feature.coverletter.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import mad.feature.coverletter.CoverLetterRoute

const val coverLetterRoute = "cover_letter_route"

fun NavController.navigateToCoverLetter(navOptions: NavOptions? = null) {
    this.navigate(coverLetterRoute, navOptions)
}

fun NavGraphBuilder.coverLetterScreen() {
    composable(route = coverLetterRoute) {
        CoverLetterRoute()
    }
}