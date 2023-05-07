package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

/**
 * Adds padding to accommodate the [safe drawing][WindowInsets.Companion.safeDrawing] insets.
 */
@ExperimentalSoftwareKeyboardApi
fun Modifier.safeDrawingPadding() = Modifier.windowInsetsPadding {
    WindowInsets.safeDrawing
}

/**
 * Adds padding to accommodate the [safe area][WindowInsets.Companion.safeArea] insets.
 */
fun Modifier.safeAreaPadding() = Modifier.windowInsetsPadding {
    WindowInsets.safeArea
}

/**
 * Adds padding to accommodate the [system bars][WindowInsets.Companion.systemBars] insets.
 */
fun Modifier.systemBarsPadding() = Modifier.windowInsetsPadding {
    WindowInsets.systemBars
}

/**
 * Adds padding to accommodate the [status bars][WindowInsets.Companion.statusBars] insets.
 */
fun Modifier.statusBarsPadding() = Modifier.windowInsetsPadding {
    WindowInsets.statusBars
}

/**
 * Adds padding to accommodate the [ime][WindowInsets.Companion.ime] insets.
 */
@ExperimentalSoftwareKeyboardApi
fun Modifier.imePadding() = Modifier.windowInsetsPadding {
    WindowInsets.ime
}

/**
 * Adds padding to accommodate the [navigation bars][WindowInsets.Companion.navigationBars] insets.
 */
fun Modifier.navigationBarsPadding() = Modifier.windowInsetsPadding {
    WindowInsets.navigationBars
}

private inline fun Modifier.windowInsetsPadding(
    crossinline block: @Composable () -> WindowInsets,
): Modifier = composed {
    Modifier.windowInsetsPadding(block())
}
