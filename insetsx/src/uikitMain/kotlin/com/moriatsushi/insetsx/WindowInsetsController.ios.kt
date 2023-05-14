package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf

@Stable
internal interface UIKitWindowInsetsController : WindowInsetsController {
    val isStatusBarVisible: Boolean
    val isNavigationBarVisible: Boolean
}

internal val LocalWindowInsetsController = staticCompositionLocalOf<UIKitWindowInsetsController?> {
    null
}

/**
 * Find and return a [WindowInsetsController].
 */
@Composable
actual fun rememberWindowInsetsController(): WindowInsetsController? {
    return LocalWindowInsetsController.current
}
