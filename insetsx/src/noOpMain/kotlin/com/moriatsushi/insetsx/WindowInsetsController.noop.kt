package com.moriatsushi.insetsx

import androidx.compose.runtime.Composable

/**
 * It always returns `null`.
 */
@Composable
actual fun rememberWindowInsetsController(): WindowInsetsController? {
    return value
}

// Workaround for Kotlin/Wasm
private val value: WindowInsetsController? = null
