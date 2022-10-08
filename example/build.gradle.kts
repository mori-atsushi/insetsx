plugins {
    kotlin("multiplatform")
    alias(libs.plugins.android.application)
}

kotlin {
    android()

    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.appcompat)
            }
        }
    }
}

android {
    namespace = "com.moriatsushi.insetsx.example"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }
}
