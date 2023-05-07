package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalWindowInsetsController = staticCompositionLocalOf<WindowInsetsController?> {
    null
}

/**
 * Find and return a [WindowInsetsController].
 */
@Composable
actual fun rememberWindowInsetsController(): WindowInsetsController? {
    return LocalWindowInsetsController.current
}
