package mad.feature.premium

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun PremiumDialog(
    onDismiss: () -> Unit,
    viewModel: PremiumViewModel = hiltViewModel(),
) {
//    val settingsUiState by viewModel.settingsUiState.collectAsStateWithLifecycle()
    PremiumDialog(onDismiss = onDismiss )
}
//
//@Composable
//fun PremiumDialog(
//    onDismiss: () -> Unit,
//) {
//    val configuration = LocalConfiguration.current
//
//    /**
//     * usePlatformDefaultWidth = false is use as a temporary fix to allow
//     * height recalculation during recomposition. This, however, causes
//     * Dialog's to occupy full width in Compact mode. Therefore max width
//     * is configured below. This should be removed when there's fix to
//     * https://issuetracker.google.com/issues/221643630
//     */
//    AlertDialog(
//        properties = DialogProperties(usePlatformDefaultWidth = false),
//        modifier = Modifier.widthIn(max = configuration.screenWidthDp.dp - 80.dp),
//        onDismissRequest = { onDismiss() },
//        title = {
//            Text(
//                text = stringResource(R.string.premium_title),
//                style = MaterialTheme.typography.titleLarge,
//            )
//        },
//        text = {
//            Divider()
//            Column(Modifier.verticalScroll(rememberScrollState())) {
//                when (settingsUiState) {
//                    SettingsUiState.Loading -> {
//                        Text(
//                            text = stringResource(string.loading),
//                            modifier = Modifier.padding(vertical = 16.dp),
//                        )
//                    }
//
//                    is SettingsUiState.Success -> {
//                        SettingsPanel(
//                            settings = settingsUiState.settings,
//                            supportDynamicColor = supportDynamicColor,
//                            onChangeThemeBrand = onChangeThemeBrand,
//                            onChangeDynamicColorPreference = onChangeDynamicColorPreference,
//                            onChangeThemeColorConfig = onChangeThemeColorConfig,
//                        )
//                    }
//                }
//                Divider(Modifier.padding(top = 8.dp))
////                LinksPanel()
//            }
//        },
//        confirmButton = {
//            Text(
//                text = stringResource(R.strings.dismiss_dialog_button_text),
//                style = MaterialTheme.typography.labelLarge,
//                color = MaterialTheme.colorScheme.primary,
//                modifier = Modifier
//                    .padding(horizontal = 8.dp)
//                    .clickable { onDismiss() },
//            )
//        },
//    )
//}
//
//// [ColumnScope] is used for using the [ColumnScope.AnimatedVisibility] extension overload composable.
//@Composable
//private fun ColumnScope.SettingsPanel(
//    settings: UserEditableSettings,
//    supportDynamicColor: Boolean,
//    onChangeThemeBrand: (themeBrand: ThemeBrand) -> Unit,
//    onChangeDynamicColorPreference: (useDynamicColor: Boolean) -> Unit,
//    onChangeThemeColorConfig: (themeColorConfig: ThemeColorConfig) -> Unit,
//) {
//    SettingsDialogSectionTitle(text = stringResource(string.theme))
//    Column(Modifier.selectableGroup()) {
//        SettingsDialogThemeChooserRow(
//            text = stringResource(string.brand_default),
//            selected = settings.brand == ThemeBrand.DEFAULT,
//            onClick = { onChangeThemeBrand(ThemeBrand.DEFAULT) },
//        )
//        SettingsDialogThemeChooserRow(
//            text = stringResource(string.brand_android),
//            selected = settings.brand == ThemeBrand.ANDROID,
//            onClick = { onChangeThemeBrand(ThemeBrand.ANDROID) },
//        )
//    }
//    AnimatedVisibility(visible = settings.brand == ThemeBrand.DEFAULT && supportDynamicColor) {
//        Column {
//            SettingsDialogSectionTitle(text = stringResource(string.dynamic_color_preference))
//            Column(Modifier.selectableGroup()) {
//                SettingsDialogThemeChooserRow(
//                    text = stringResource(string.dynamic_color_yes),
//                    selected = settings.useDynamicColor,
//                    onClick = { onChangeDynamicColorPreference(true) },
//                )
//                SettingsDialogThemeChooserRow(
//                    text = stringResource(string.dynamic_color_no),
//                    selected = !settings.useDynamicColor,
//                    onClick = { onChangeDynamicColorPreference(false) },
//                )
//            }
//        }
//    }
//    SettingsDialogSectionTitle(text = stringResource(string.dark_mode_preference))
//    Column(Modifier.selectableGroup()) {
//        SettingsDialogThemeChooserRow(
//            text = stringResource(string.dark_mode_config_system_default),
//            selected = settings.themeColorConfig == ThemeColorConfig.FOLLOW_SYSTEM,
//            onClick = { onChangeThemeColorConfig(ThemeColorConfig.FOLLOW_SYSTEM) },
//        )
//        SettingsDialogThemeChooserRow(
//            text = stringResource(string.dark_mode_config_light),
//            selected = settings.themeColorConfig == ThemeColorConfig.LIGHT,
//            onClick = { onChangeThemeColorConfig(ThemeColorConfig.LIGHT) },
//        )
//        SettingsDialogThemeChooserRow(
//            text = stringResource(string.dark_mode_config_dark),
//            selected = settings.themeColorConfig == ThemeColorConfig.DARK,
//            onClick = { onChangeThemeColorConfig(ThemeColorConfig.DARK) },
//        )
//    }
//}
//
//@Composable
//private fun SettingsDialogSectionTitle(text: String) {
//    Text(
//        text = text,
//        style = MaterialTheme.typography.titleMedium,
//        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
//    )
//}
//
//@Composable
//fun SettingsDialogThemeChooserRow(
//    text: String,
//    selected: Boolean,
//    onClick: () -> Unit,
//) {
//    Row(
//        Modifier
//            .fillMaxWidth()
//            .selectable(
//                selected = selected,
//                role = Role.RadioButton,
//                onClick = onClick,
//            )
//            .padding(12.dp),
//        verticalAlignment = Alignment.CenterVertically,
//    ) {
//        RadioButton(
//            selected = selected,
//            onClick = null,
//        )
//        Spacer(Modifier.width(8.dp))
//        Text(text)
//    }
//}

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

