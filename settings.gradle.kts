pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            version("kotlin", "1.7.10")
            version("agp", "7.3.0")
            version("androidx-appcompat", "1.5.1")

            library("androidx-appcompat", "androidx.appcompat", "appcompat")
                .versionRef("androidx-appcompat")

            plugin("android-application", "com.android.application")
                .versionRef("agp")
            plugin("android-library", "com.android.library")
                .versionRef("agp")
        }
    }
}

rootProject.name = "insetsx"
include(":insetsx")
include(":example")
