plugins {
    alias(libs.plugins.nowinandroid.android.feature)
    alias(libs.plugins.nowinandroid.android.library.compose)
}

android {
    namespace = "mad.feature.profile"
}

dependencies {
    implementation(libs.androidx.compose.material3.windowSizeClass)
}