package mad.feature.preview

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import mad.core.model.template.CvForgeTemplate
import mad.core.model.template.state.TemplateUiState
import mad.feature.preview.navigation.PreviewArgs
import javax.inject.Inject

@HiltViewModel
class PreviewViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val previewArgs: PreviewArgs = PreviewArgs(savedStateHandle)

    val templateId = previewArgs.templateId

    val templateUiState: StateFlow<TemplateUiState> =
        getTestTemplate()
            .map(TemplateUiState::Success)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = TemplateUiState.Loading,
            )

}

fun getTestTemplate() = flow {
    emit(
        CvForgeTemplate(emptyList())
    )

}
