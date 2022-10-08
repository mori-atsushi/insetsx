plugins {
    val kotlinVersion = libs.versions.kotlin.get()

    kotlin("multiplatform").version(kotlinVersion) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.compose) apply false
}
