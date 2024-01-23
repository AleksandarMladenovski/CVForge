plugins {
    alias(libs.plugins.nowinandroid.android.feature)
    alias(libs.plugins.nowinandroid.android.library.compose)
}

android {
    namespace = "mad.feature.coverletter"
}

dependencies {
    implementation(libs.androidx.compose.material3.windowSizeClass)
}