plugins {
    alias(libs.plugins.nowinandroid.android.feature)
    alias(libs.plugins.nowinandroid.android.library.compose)
}

android {
    namespace = "mad.feature.preview"
}

dependencies {
    implementation(projects.core.pdf)
    implementation(libs.androidx.compose.material3.windowSizeClass)
}