package mad.core.data.repository

import kotlinx.coroutines.flow.Flow
import mad.core.datastore.CVForgeDataStore
import mad.core.model.theme.ThemeBrand
import mad.core.model.theme.ThemeColorConfig
import mad.core.model.theme.UserData
import javax.inject.Inject

class OfflineUserDataRepository @Inject constructor(
    private val dataStore: CVForgeDataStore
) : UserDataRepository {
    override val userData: Flow<UserData> = dataStore.userData

    override suspend fun setThemeBrand(themeBrand: ThemeBrand) {
        dataStore.setThemeBrand(themeBrand)
    }

    override suspend fun setThemeColorConfig(themeColorConfig: ThemeColorConfig) {
        dataStore.setThemeColorConfig(themeColorConfig)
    }

    override suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        dataStore.setDynamicColorPreference(useDynamicColor)
    }
}