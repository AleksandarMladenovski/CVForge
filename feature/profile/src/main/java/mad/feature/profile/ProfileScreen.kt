package mad.feature.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun ProfileRoute(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel(),
) {
//    val feedState by viewModel.feedUiState.collectAsStateWithLifecycle()
    ProfileScreen(
        modifier = modifier
    )
}
@Composable
internal fun ProfileScreen(modifier: Modifier = Modifier) {
}