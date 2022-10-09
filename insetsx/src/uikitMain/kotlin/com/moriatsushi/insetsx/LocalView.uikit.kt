package com.moriatsushi.insetsx

import androidx.compose.runtime.staticCompositionLocalOf
import platform.UIKit.UIView

internal val LocalView = staticCompositionLocalOf<UIView> {
    error("CompositionLocal LocalView not present")
}
