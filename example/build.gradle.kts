import org.jetbrains.compose.experimental.dsl.IOSDevices

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose)
}

kotlin {
    android()
    listOf(
        iosX64("uikitX64"),
        iosArm64("uikitArm64"),
        iosSimulatorArm64("uikitSimArm64")
    ).forEach {
        it.binaries {
            executable {
                entryPoint = "main"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal",
                    "-linker-option", "-framework", "-linker-option", "CoreText",
                    "-linker-option", "-framework", "-linker-option", "CoreGraphics",
                    "-Xverify-compiler=false", // Workaround for https://youtrack.jetbrains.com/issue/KT-53561
                )
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":insetsx"))
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)

                // Workaround for https://youtrack.jetbrains.com/issue/KT-41821
                implementation(libs.kotlinx.atomicfu)
            }
        }

        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.androidx.appcompat)
                implementation(libs.androidx.activity.compose)
            }
        }
        val uikitMain by creating {
            dependsOn(commonMain)
        }
        val uikitX64Main by getting {
            dependsOn(uikitMain)
        }
        val uikitArm64Main by getting {
            dependsOn(uikitMain)
        }
        val uikitSimArm64Main by getting {
            dependsOn(uikitMain)
        }
    }
}

compose {
    experimental {
        uikit.application {
            bundleIdPrefix = "com.moriatsushi"
            projectName = "InsetsX"
            deployConfigurations {
                simulator("IPhone13") {
                    //Usage: ./gradlew :example:iosDeployIPhone13Debug
                    device = IOSDevices.IPHONE_13
                }
                simulator("iPhone8") {
                    //Usage: ./gradlew :example:iosDeployIPhone13Debug
                    device = IOSDevices.IPHONE_8
                }
                simulator("IPad") {
                    //Usage: ./gradlew :example:iosDeployIPadDebug
                    device = IOSDevices.IPAD_MINI_6th_Gen
                }
                connectedDevice("Device") {
                    //First need specify your teamId here, or in local.properties (compose.ios.teamId=***)
                    //teamId="***"
                    //Usage: ./gradlew :example:iosDeployDeviceRelease
                }
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
