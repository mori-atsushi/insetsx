import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin

plugins {
    val kotlinVersion = libs.versions.kotlin.get()

    kotlin("multiplatform").version(kotlinVersion) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.compose) apply false
    alias(libs.plugins.spotless) apply false
}

subprojects {
    apply<SpotlessPlugin>()

    extensions.configure<SpotlessExtension> {
        kotlin {
            target("**/*.kt")
            val ktlintVersion = libs.versions.ktlint.get()
            targetExclude("**/build/**/*.kt")
            ktlint(ktlintVersion)
                .editorConfigOverride(
                    mapOf(
                        "ktlint_code_style" to "android",
                        "ij_kotlin_allow_trailing_comma" to true,
                    )
                )
        }
    }
}
