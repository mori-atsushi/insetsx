plugins {
    kotlin("multiplatform")
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.publish)
}

kotlin {
    android {
        publishLibraryVariants("release")
    }

    listOf(
        iosX64("uikitX64"),
        iosArm64("uikitArm64"),
        iosSimulatorArm64("uikitSimArm64")
    ).forEach {
        it.binaries.framework {
            baseName = "insetsx"
        }
        it.compilations.getByName("main") {
            cinterops {
                //  Workaround to override uikit classes
                val uikit by cinterops.creating {
                }
            }
        }
    }

    jvm("desktop")

    js(IR) {
        browser()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.foundation)
                implementation(compose.runtime)

                // Workaround for https://youtrack.jetbrains.com/issue/KT-41821
                implementation(libs.kotlinx.atomicfu)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.accompanist.systemuicontroller)
                implementation(libs.androidx.core)
            }
        }
        val androidUnitTest by getting
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
        val uikitTest by creating {
            dependsOn(commonTest)
        }
        val noOpMain by creating {
            dependsOn(commonMain)
        }
        val desktopMain by getting {
            dependsOn(noOpMain)
        }
        val jsMain by getting {
            dependsOn(noOpMain)
        }
    }
}

android {
    namespace = "com.moriatsushi.insetsx"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }

    buildFeatures {
        buildConfig = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
