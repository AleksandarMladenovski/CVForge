package mad.feature.settings

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mad.core.designsystem.theme.supportsDynamicTheming
import mad.core.model.theme.ThemeBrand
import mad.core.model.theme.ThemeColorConfig
import mad.feature.settings.model.SettingsUiState
import mad.feature.settings.model.UserEditableSettings

@Composable
internal fun SettingsRoute(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val settingsUiState by viewModel.settingsUiState.collectAsStateWithLifecycle()
    SavedScreen(
        modifier = modifier,
        settingsUiState = settingsUiState,
        onChangeThemeBrand = viewModel::updateThemeBrand,
        onChangeDynamicColorPreference = viewModel::updateDynamicColorPreference,
        onChangeThemeColorConfig = viewModel::updateThemeColorConfig,
    )
}

@Composable
internal fun SavedScreen(
    modifier: Modifier = Modifier,
    settingsUiState: SettingsUiState,
    supportDynamicColor: Boolean = supportsDynamicTheming(),
    onChangeThemeBrand: (themeBrand: ThemeBrand) -> Unit,
    onChangeDynamicColorPreference: (useDynamicColor: Boolean) -> Unit,
    onChangeThemeColorConfig: (themeColorConfig: ThemeColorConfig) -> Unit,
) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        when (settingsUiState) {
            SettingsUiState.Loading -> {
                Text(
                    text = stringResource(R.string.loading),
                    modifier = Modifier.padding(vertical = 16.dp),
                )
            }

            is SettingsUiState.Success -> {
                SettingsPanel(
                    settings = settingsUiState.settings,
                    supportDynamicColor = supportDynamicColor,
                    onChangeThemeBrand = onChangeThemeBrand,
                    onChangeDynamicColorPreference = onChangeDynamicColorPreference,
                    onChangeThemeColorConfig = onChangeThemeColorConfig,
                )
            }
        }
        Divider(Modifier.padding(top = 8.dp))
//                LinksPanel()
    }

}

// [ColumnScope] is used for using the [ColumnScope.AnimatedVisibility] extension overload composable.
@Composable
private fun ColumnScope.SettingsPanel(
    settings: UserEditableSettings,
    supportDynamicColor: Boolean,
    onChangeThemeBrand: (themeBrand: ThemeBrand) -> Unit,
    onChangeDynamicColorPreference: (useDynamicColor: Boolean) -> Unit,
    onChangeThemeColorConfig: (themeColorConfig: ThemeColorConfig) -> Unit,
) {
    SettingsDialogSectionTitle(text = stringResource(R.string.theme))
    Column(Modifier.selectableGroup()) {
        SettingsDialogThemeChooserRow(
            text = stringResource(R.string.brand_default),
            selected = settings.brand == ThemeBrand.DEFAULT,
            onClick = { onChangeThemeBrand(ThemeBrand.DEFAULT) },
        )
        SettingsDialogThemeChooserRow(
            text = stringResource(R.string.brand_android),
            selected = settings.brand == ThemeBrand.ANDROID,
            onClick = { onChangeThemeBrand(ThemeBrand.ANDROID) },
        )
    }
    AnimatedVisibility(visible = settings.brand == ThemeBrand.DEFAULT && supportDynamicColor) {
        Column {
            SettingsDialogSectionTitle(text = stringResource(R.string.dynamic_color_preference))
            Column(Modifier.selectableGroup()) {
                SettingsDialogThemeChooserRow(
                    text = stringResource(R.string.dynamic_color_yes),
                    selected = settings.useDynamicColor,
                    onClick = { onChangeDynamicColorPreference(true) },
                )
                SettingsDialogThemeChooserRow(
                    text = stringResource(R.string.dynamic_color_no),
                    selected = !settings.useDynamicColor,
                    onClick = { onChangeDynamicColorPreference(false) },
                )
            }
        }
    }
    SettingsDialogSectionTitle(text = stringResource(R.string.dark_mode_preference))
    Column(Modifier.selectableGroup()) {
        SettingsDialogThemeChooserRow(
            text = stringResource(R.string.dark_mode_config_system_default),
            selected = settings.themeColorConfig == ThemeColorConfig.FOLLOW_SYSTEM,
            onClick = { onChangeThemeColorConfig(ThemeColorConfig.FOLLOW_SYSTEM) },
        )
        SettingsDialogThemeChooserRow(
            text = stringResource(R.string.dark_mode_config_light),
            selected = settings.themeColorConfig == ThemeColorConfig.LIGHT,
            onClick = { onChangeThemeColorConfig(ThemeColorConfig.LIGHT) },
        )
        SettingsDialogThemeChooserRow(
            text = stringResource(R.string.dark_mode_config_dark),
            selected = settings.themeColorConfig == ThemeColorConfig.DARK,
            onClick = { onChangeThemeColorConfig(ThemeColorConfig.DARK) },
        )
    }
}

@Composable
private fun SettingsDialogSectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
    )
}

@Composable
fun SettingsDialogThemeChooserRow(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .selectable(
                selected = selected,
                role = Role.RadioButton,
                onClick = onClick,
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RadioButton(
            selected = selected,
            onClick = null,
        )
        Spacer(Modifier.width(8.dp))
        Text(text)
    }
}

//@Preview
//@Composable
//private fun PreviewSettingsDialog() {
//    NiaTheme {
//        SettingsDialog(
//            onDismiss = {},
//            settingsUiState = Success(
//                UserEditableSettings(
//                    brand = DEFAULT,
//                    darkThemeConfig = FOLLOW_SYSTEM,
//                    useDynamicColor = false,
//                ),
//            ),
//            onChangeThemeBrand = {},
//            onChangeDynamicColorPreference = {},
//            onChangeDarkThemeConfig = {},
//        )
//    }
//}
//
//@Preview
//@Composable
//private fun PreviewSettingsDialogLoading() {
//    NiaTheme {
//        SettingsDialog(
//            onDismiss = {},
//            settingsUiState = Loading,
//            onChangeThemeBrand = {},
//            onChangeDynamicColorPreference = {},
//            onChangeDarkThemeConfig = {},
//        )
//    }
//}


