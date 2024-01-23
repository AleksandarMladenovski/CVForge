package mad.core.model.template.state

import mad.core.model.template.CvForgeTemplate

sealed interface TemplateUiState {
    data object Loading : TemplateUiState
    data class Success(val template: CvForgeTemplate) : TemplateUiState
}