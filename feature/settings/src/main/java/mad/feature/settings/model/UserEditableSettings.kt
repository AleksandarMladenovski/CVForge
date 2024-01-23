package mad.feature.settings.model

import mad.core.model.theme.ThemeBrand
import mad.core.model.theme.ThemeColorConfig

data class UserEditableSettings(
    val brand: ThemeBrand,
    val useDynamicColor: Boolean,
    val themeColorConfig: ThemeColorConfig,
)
