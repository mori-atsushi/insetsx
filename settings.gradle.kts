pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    versionCatalogs {
        create("libs") {
            version("kotlin", "1.7.10")
            version("kotlinx-atomicfu", "0.17.3")
            version("agp", "7.3.0")
            version("androidx-appcompat", "1.5.1")
            version("androidx-activity", "1.6.0")
            version("jetbrains-compose", "1.2.0-beta02")
            version("spotless", "6.11.0")
            version("ktlint", "0.47.1")

            library("kotlinx-atomicfu", "org.jetbrains.kotlinx", "atomicfu")
                .versionRef("kotlinx-atomicfu")
            library("androidx-appcompat", "androidx.appcompat", "appcompat")
                .versionRef("androidx-appcompat")
            library("androidx-activity-compose", "androidx.activity", "activity-compose")
                .versionRef("androidx-activity")

            plugin("android-application", "com.android.application")
                .versionRef("agp")
            plugin("android-library", "com.android.library")
                .versionRef("agp")
            plugin("jetbrains-compose", "org.jetbrains.compose")
                .versionRef("jetbrains-compose")
            plugin("spotless", "com.diffplug.spotless")
                .versionRef("spotless")
        }
    }
}

rootProject.name = "insetsx"
include(":insetsx")
include(":example")
