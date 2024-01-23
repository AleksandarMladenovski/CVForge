plugins {
    alias(libs.plugins.nowinandroid.android.feature)
    alias(libs.plugins.nowinandroid.android.library.compose)
}

android {
    namespace = "mad.feature.resume"
}

dependencies {
    implementation(projects.feature.preview)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
}