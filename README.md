## InsetsX  [🚧 Work in progress 🚧]
[![](https://img.shields.io/badge/Kotlin-Multiplatform-%237f52ff?logo=kotlin)](https://kotlinlang.org/docs/multiplatform.html)
[![](https://img.shields.io/maven-central/v/com.moriatsushi.insetsx/insetsx)](https://mvnrepository.com/artifact/com.moriatsushi.insetsx/insetsx)
[![](https://img.shields.io/github/license/mori-atsushi/insetsx)](https://github.com/mori-atsushi/insetsx/blob/main/LICENSE)

<img src="https://user-images.githubusercontent.com/13435109/236607484-22248c02-65de-4954-97a3-349907a2343e.png" width="720px"/>

InsetsX provides a [WindowInsets](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/WindowInsets) utility for [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/).

The goal is to have a unified interface for handling WindowInsets across iOS and Android.

Once the official library supports WindowInsets, this library will be archived.

## Setup
To use InsetsX, add the following dependency:

```kotlin
kotlin {
    /* ... */

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.moriatsushi.insetsx:insetsx:0.1.0-alpha07")
            }
        }
    }
}
```

### Android
1. (option) If you are using insets for IME support, set the activity's `windowSoftInputMode` to `adjustResize` in your AndroidManifest.xml file.

```xml
<activity
      android:name=".MyActivity"
      android:windowSoftInputMode="adjustResize">
</activity>
```

2. Call `WindowCompat.setDecorFitsSystemWindows()` with `false` in the `onCreate` method of the activity .

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    WindowCompat.setDecorFitsSystemWindows(window, false)
}
```

Detail: [Lay out your app within window insets](https://developer.android.com/develop/ui/views/layout/insets)

### iOS

1. (option) If you want to use the `WindowInsetsController`, use `WindowInsetsUIViewController` instead of `ComposeUIViewController`.

```kotlin
fun MainUIViewController(): UIViewController {
    return WindowInsetsUIViewController {
        MyApp()
    }
}
```

## How to use
### WindowInsets
This works much like Android's WindowInsets.
Please note that the package name is different.

```kotlin
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moriatsushi.insetsx.systemBars
import com.moriatsushi.insetsx.systemBarsPadding

@Composable
fun Sample() {
    val modifier1 = Modifier
        .windowInsetsPadding(WindowInsets.safeDrawing)

    val modifier2 = Modifier
        .safeDrawingPadding()
}
```

API|android|ios
:--|:--|:--
WindowInsets.safeArea|system bars + display cutouts|SafeArea
WindowInsets.systemBars|status bar + navigation bar|home indicator + status bar
WindowInsets.navigationBars|navigation bar|home indicator
WindowInsets.statusBars|status bar|status bar
WindowInsets.ime *1|software keyboard|software keyboard
WindowInsets.safeDrawing *1|system bars + software keyboard|SafeArea + software keyboard
(Modifier)||
Modifier.safeAreaPadding()|system bars + display cutouts|SafeArea
Modifier.systemBarsPadding()|status bar + navigation bar|home indicator + status bar
Modifier.navigationBarsPadding()|navigation bar|home indicator
Modifier.statusBarsPadding()|status bar|status bar
Modifier.imePadding() *1|software keyboard|software keyboard
Modifier.safeDrawingPadding() *1|system bars + software keyboard|SafeArea + software keyboard

*1 is experimental

### WindowInsetsController
`WindowInsetsController` can be used to change colors of system bars.

```kotlin
@Composable
fun Sample() {
    val windowInsetsController = rememberWindowInsetsController()
    LaunchedEffect(Unit) {
        // The status bars icon + content will change to a light color
        windowInsetsController?.setStatusBarContentColor(dark = false)
        // The navigation bars icons will change to a light color (android only)
        windowInsetsController?.setNavigationBarsContentColor(dark = false)
    }
}
```

You can also hide WindowInsets.

```kotlin
@Composable
fun Sample() {
    val windowInsetsController = rememberWindowInsetsController()
    LaunchedEffect(Unit) {
        // Hide the status bars
        windowInsetsController?.setIsStatusBarsVisible(false)
        // Hide the navigation bars
        windowInsetsController?.setIsNavigationBarsVisible(false)
        // Change an options for behavior when system bars are hidden
        windowInsetsController?.setSystemBarsBehavior(SystemBarsBehavior.Immersive)
    }
}
```
