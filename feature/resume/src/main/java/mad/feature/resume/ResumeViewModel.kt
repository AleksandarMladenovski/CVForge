package mad.feature.resume

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import mad.core.model.template.state.TemplateUiState
import javax.inject.Inject

@HiltViewModel
class ResumeViewModel @Inject constructor() : ViewModel() {
    val templateUiState: StateFlow<TemplateUiState> =
        TempRepo.getTestTemplate()
            .map(TemplateUiState::Success)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = TemplateUiState.Loading,
            )
}