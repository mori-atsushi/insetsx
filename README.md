## InsetsX  [🚧 Work in progress 🚧]
[![](https://img.shields.io/badge/Kotlin-Multiplatform-%237f52ff?logo=kotlin)](https://kotlinlang.org/docs/multiplatform.html)
[![](https://img.shields.io/maven-central/v/com.moriatsushi.insetsx/insetsx)](https://mvnrepository.com/artifact/com.moriatsushi.insetsx/insetsx)
[![](https://img.shields.io/github/license/mori-atsushi/insetsx)](https://github.com/mori-atsushi/insetsx/blob/main/LICENSE)

<img src="https://user-images.githubusercontent.com/13435109/236607484-22248c02-65de-4954-97a3-349907a2343e.png" width="720px"/>

InsetsX provides a [WindowInsets](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/WindowInsets) utility for [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/).

It aim to work with WindowInsets with the same interface on iOS and Android.

This library will be archived when the official library can handle WindowInsets.

## Setup
Add the dependency as follows:

```kotlin
kotlin {
    /* ... */

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.moriatsushi.insetsx:insetsx:0.1.0-alpha04")
            }
        }
    }
}
```

## How to use
This works much like Android's WindowInsets.
Please note that the package name is different.

```kotlin
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.ui.Modifier
import com.moriatsushi.insetsx.systemBars
import com.moriatsushi.insetsx.systemBarsPadding

val modifier1 = Modifier
    .windowInsetsPadding(WindowInsets.systemBars)

val modifier2 = Modifier
    .systemBarsPadding()
```

## APIs

API|android|ios
:--|:--|:--
WindowInsets.systemBars|status bar + navigation bar|SafeArea
WindowInsets.navigationBars|navigation bar|bottom of SafeArea
WindowInsets.statusBars|status bar|top and horizontal of SafeArea
WindowInsets.ime *1|software keyboard|software keyboard
WindowInsets.safeDrawing *1|system bars + software keyboard|SafeArea + software keyboard
Modifier.systemBarsPadding()|status bar + navigation bar|SafeArea
Modifier.navigationBarsPadding()|navigation bar|bottom of SafeArea
Modifier.statusBarsPadding()|status bar|top and horizontal of SafeArea
Modifier.imePadding() *1|software keyboard|software keyboard
Modifier.safeDrawingPadding() *1|system bars + software keyboard|SafeArea + software keyboard

*1 is experimental
