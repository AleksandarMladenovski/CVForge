package mad.feature.coverletter

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun CoverLetterRoute(
    modifier: Modifier = Modifier,
    viewModel: CoverLetterViewModel = hiltViewModel(),
) {
//    val feedState by viewModel.feedUiState.collectAsStateWithLifecycle()
    CoverLetterScreen(
        modifier = modifier
    )
}

@Composable
internal fun CoverLetterScreen(modifier: Modifier = Modifier) {
}