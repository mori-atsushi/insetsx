pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
        google()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
        google()
    }

    versionCatalogs {
        create("libs") {
            version("kotlin", "1.8.20")
            version("kotlinx-atomicfu", "0.21.0")
            version("agp", "8.1.0")
            version("androidx-appcompat", "1.6.1")
            version("androidx-activity", "1.7.2")
            version("androidx-core", "1.10.1")
            version("jetbrains-compose", "1.4.0-dev-wasm06")
            version("accompanist", "0.30.1")
            version("spotless", "6.22.0")
            version("ktlint", "0.48.1")
            version("publish", "0.30.0")

            library("kotlinx-atomicfu", "org.jetbrains.kotlinx", "atomicfu")
                .versionRef("kotlinx-atomicfu")
            library("androidx-appcompat", "androidx.appcompat", "appcompat")
                .versionRef("androidx-appcompat")
            library("androidx-core", "androidx.core", "core-ktx")
                .versionRef("androidx-core")
            library("androidx-activity-compose", "androidx.activity", "activity-compose")
                .versionRef("androidx-activity")
            library(
                "accompanist-systemuicontroller",
                "com.google.accompanist",
                "accompanist-systemuicontroller"
            )
                .versionRef("accompanist")

            plugin("android-application", "com.android.application")
                .versionRef("agp")
            plugin("android-library", "com.android.library")
                .versionRef("agp")
            plugin("jetbrains-compose", "org.jetbrains.compose")
                .versionRef("jetbrains-compose")
            plugin("spotless", "com.diffplug.spotless")
                .versionRef("spotless")
            plugin("publish", "com.vanniktech.maven.publish")
                .versionRef("publish")
        }
    }
}

rootProject.name = "insetsx"
include(":insetsx")
include(":example")
