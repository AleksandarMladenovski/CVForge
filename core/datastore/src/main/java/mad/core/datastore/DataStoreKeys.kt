package mad.core.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey

object DataStoreKeys {
    val KEY_THEME_BRAND = intPreferencesKey("THEME_BRAND_DATASTORE_KEY")
    val KEY_THEME_COLOR_CONFIG = intPreferencesKey("THEME_COLOR_CONFIG_DATASTORE_KEY")
    val KEY_USE_DYNAMIC_COLOR = booleanPreferencesKey("USE_DYNAMIC_COLOR_DATASTORE_KEY")
}