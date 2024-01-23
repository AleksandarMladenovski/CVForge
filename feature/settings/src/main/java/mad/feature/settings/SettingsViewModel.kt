package mad.feature.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import mad.core.data.repository.UserDataRepository
import mad.core.model.theme.ThemeBrand
import mad.core.model.theme.ThemeColorConfig
import mad.feature.settings.model.SettingsUiState
import mad.feature.settings.model.UserEditableSettings
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,
) : ViewModel() {
    val settingsUiState: StateFlow<SettingsUiState> = userDataRepository.userData.map { userData ->
        SettingsUiState.Success(
            settings = UserEditableSettings(
                brand = userData.themeBrand,
                useDynamicColor = userData.useDynamicColor,
                themeColorConfig = userData.themeColorConfig,
            ),
        )
    }.stateIn(
        scope = viewModelScope,
        // TODO: Change to SharingStarted.WhileSubscribed(5_000)
        started = SharingStarted.Eagerly,
        initialValue = SettingsUiState.Loading,
    )

    fun updateThemeBrand(themeBrand: ThemeBrand) {
        viewModelScope.launch {
            userDataRepository.setThemeBrand(themeBrand)
        }
    }

    fun updateThemeColorConfig(themeColorConfig: ThemeColorConfig) {
        viewModelScope.launch {
            userDataRepository.setThemeColorConfig(themeColorConfig)
        }
    }

    fun updateDynamicColorPreference(useDynamicColor: Boolean) {
        viewModelScope.launch {
            userDataRepository.setDynamicColorPreference(useDynamicColor)
        }
    }
}

