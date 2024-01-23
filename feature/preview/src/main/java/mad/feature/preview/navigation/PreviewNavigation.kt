package mad.feature.preview.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import mad.feature.preview.PreviewRoute
import java.net.URLDecoder
import java.net.URLEncoder

const val previewRoute = "preview_route"
internal const val templateIdArg = "templateId"

internal class PreviewArgs(val templateId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(
                URLDecoder.decode(
                    checkNotNull(savedStateHandle[templateIdArg]),
                    Charsets.UTF_8.name()
                )
            )
}

fun NavController.navigateToPreview(templateId: String, navOptions: NavOptions? = null) {
    val encodedId = URLEncoder.encode(templateId, Charsets.UTF_8.name())
    this.navigate("$previewRoute/$encodedId") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.previewScreen() {
    composable(
        route = "$previewRoute/{$templateIdArg}",
        arguments = listOf(
            navArgument(templateIdArg) { type = NavType.StringType },
        ),
    ) {
        PreviewRoute()
    }
}