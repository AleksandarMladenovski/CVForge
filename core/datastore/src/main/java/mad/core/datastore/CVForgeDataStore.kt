package mad.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.map
import mad.core.datastore.DataStoreKeys.KEY_THEME_BRAND
import mad.core.datastore.DataStoreKeys.KEY_THEME_COLOR_CONFIG
import mad.core.datastore.DataStoreKeys.KEY_USE_DYNAMIC_COLOR
import mad.core.model.theme.ThemeBrand
import mad.core.model.theme.ThemeColorConfig
import mad.core.model.theme.UserData
import javax.inject.Inject

class CVForgeDataStore @Inject constructor(
    private val preferences: DataStore<Preferences>,
) {
    val userData = preferences.data.map { prefs ->
        UserData(
            themeBrand = when (prefs[KEY_THEME_BRAND] ?: -1) {
                ThemeBrand.ANDROID.ordinal -> ThemeBrand.ANDROID
                ThemeBrand.DEFAULT.ordinal -> ThemeBrand.DEFAULT
                else -> ThemeBrand.DEFAULT
            },
            themeColorConfig = when (prefs[KEY_THEME_COLOR_CONFIG] ?: -1) {
                ThemeColorConfig.DARK.ordinal -> ThemeColorConfig.DARK
                ThemeColorConfig.LIGHT.ordinal -> ThemeColorConfig.LIGHT
                ThemeColorConfig.FOLLOW_SYSTEM.ordinal -> ThemeColorConfig.FOLLOW_SYSTEM
                else -> ThemeColorConfig.FOLLOW_SYSTEM
            },
            useDynamicColor = prefs[KEY_USE_DYNAMIC_COLOR] ?: false
        )
    }
    //TODO CATCH EXCEPTION!!!

    suspend fun setThemeBrand(themeBrand: ThemeBrand) {
        preferences.edit { prefs ->
            prefs[KEY_THEME_BRAND] = themeBrand.ordinal
        }
    }

    suspend fun setThemeColorConfig(themeColorConfig: ThemeColorConfig) {
        preferences.edit { prefs ->
            prefs[KEY_THEME_COLOR_CONFIG] = themeColorConfig.ordinal
        }
    }

    suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        preferences.edit { prefs ->
            prefs[KEY_USE_DYNAMIC_COLOR] = useDynamicColor
        }
    }

}