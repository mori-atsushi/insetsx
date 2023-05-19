package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable

/**
 * It always returns `null`, because Desktop has no window insets.
 */
@Composable
actual fun rememberWindowInsetsController(): WindowInsetsController? {
    return null
}
