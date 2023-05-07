package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable

/**
 * The insets representing the home indicator.
 */
actual val WindowInsets.Companion.navigationBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().navigationBars

/**
 * The insets representing the status bar.
 */
actual val WindowInsets.Companion.statusBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().statusBars

/**
 * The insets representing system bars, but not including ime.
 */
actual val WindowInsets.Companion.systemBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().systemBars

/**
 * The insets representing the safe area.
 */
@ExperimentalSoftwareKeyboardApi
actual val WindowInsets.Companion.safeArea: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().safeArea

/**
 * The insets representing the area of the software keyboard.
 */
@ExperimentalSoftwareKeyboardApi
actual val WindowInsets.Companion.ime: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().ime

/**
 * The insets that include areas where content may be covered by other drawn content.
 */
@ExperimentalSoftwareKeyboardApi
actual val WindowInsets.Companion.safeDrawing: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().safeDrawing
