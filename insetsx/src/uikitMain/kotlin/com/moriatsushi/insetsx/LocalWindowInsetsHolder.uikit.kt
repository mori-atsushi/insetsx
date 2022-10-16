package com.moriatsushi.insetsx

import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalWindowInsetsHolder = staticCompositionLocalOf<WindowInsetsHolder> {
    error("CompositionLocal WindowInsetsHolder not present")
}
