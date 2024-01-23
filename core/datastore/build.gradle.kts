plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.android.hilt)
}
android{
    namespace="mad.core.datastore"
}
dependencies{
    implementation(projects.core.model)
    implementation(libs.androidx.dataStore.preferences)
    implementation(libs.kotlinx.coroutines.android)
}