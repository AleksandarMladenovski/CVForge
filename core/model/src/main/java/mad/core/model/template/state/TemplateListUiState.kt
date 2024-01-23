package mad.core.model.template.state

import mad.core.model.template.CvForgeTemplate

sealed interface TemplateListUiState {
    data object Loading : TemplateListUiState
    data class Success(val list: List<CvForgeTemplate>) : TemplateListUiState
}