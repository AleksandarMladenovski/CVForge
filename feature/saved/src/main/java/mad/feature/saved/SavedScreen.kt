package mad.feature.saved

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun SavedRoute(
    modifier: Modifier = Modifier,
    viewModel: SavedViewModel = hiltViewModel(),
) {
//    val feedState by viewModel.feedUiState.collectAsStateWithLifecycle()
    SavedScreen(
        modifier = modifier
    )
}
@Composable
internal fun SavedScreen(modifier: Modifier = Modifier) {
}