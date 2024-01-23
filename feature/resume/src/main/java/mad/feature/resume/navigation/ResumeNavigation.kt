package mad.feature.resume.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import mad.feature.resume.ResumeRoute

//TODO PASS TEMPLATE FROM HOME SCREEN
//private val URL_CHARACTER_ENCODING = Charsets.UTF_8.name()
//
//@VisibleForTesting
//internal const val templateIdArg = "topicId"
//
//internal class TopicArgs(val topicId: String) {
//    constructor(savedStateHandle: SavedStateHandle) :
//            this(URLDecoder.decode(checkNotNull(savedStateHandle[topicIdArg]), URL_CHARACTER_ENCODING))
//}
//
//fun NavController.navigateToTopic(topicId: String) {
//    val encodedId = URLEncoder.encode(topicId, URL_CHARACTER_ENCODING)
//    this.navigate("topic_route/$encodedId") {
//        launchSingleTop = true
//    }
//}

const val resumeRoute = "resume_route"

fun NavController.navigateToResume(navOptions: NavOptions? = null) {
    this.navigate(resumeRoute, navOptions)
}

fun NavGraphBuilder.resumeScreen(
    isOnePageLayout: Boolean,
    isPreviewEnabled: Boolean,
    onNavigateToPreview: (String)-> Unit,
) {
    composable(route = resumeRoute) {
        ResumeRoute(
            isOnePageLayout = isOnePageLayout,
            isPreviewEnabled = isPreviewEnabled,
            onNavigateToPreview = onNavigateToPreview
        )
    }
}