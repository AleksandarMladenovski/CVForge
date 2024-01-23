package mad.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun HomeRoute(
    onResumeSelect: () -> Unit,
    onCoverLetterSelect: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
//    val feedState by viewModel.feedUiState.collectAsStateWithLifecycle()
    ProfileScreen(
        onResumeSelect = onResumeSelect,
        onCoverLetterSelect = onCoverLetterSelect,
        modifier = modifier
    )
}

@Composable
internal fun ProfileScreen(
    onResumeSelect: () -> Unit,
    onCoverLetterSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Button(onClick = { onResumeSelect() }) {
            Text(text = "Simulate Resume Select")
        }
        Button(onClick = { onCoverLetterSelect() }) {
            Text(text = "Simulate Cover Letter Select")
        }
    }
}