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
 * It always returns 0.
 */
actual val WindowInsets.Companion.captionBar: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = zero

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
 * The insets representing system gestures that have priority and may consume some or all touch
 * input.
 */
actual val WindowInsets.Companion.systemGestures: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().systemGestures

/**
 * The insets representing the tappable element.
 */
actual val WindowInsets.Companion.tappableElement: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().tappableElement

/**
 * The insets representing the safe area.
 */
actual val WindowInsets.Companion.safeArea: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().safeArea

/**
 * It always returns 0.
 */
actual val WindowInsets.Companion.waterfall: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = zero

/**
 * The insets representing system gestures that have priority and may consume some or all touch
 * input.
 */
actual val WindowInsets.Companion.mandatorySystemGestures: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().systemGestures

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

/**
 * The insets that include areas where gestures may be confused with other input.
 */
@ExperimentalSoftwareKeyboardApi
actual val WindowInsets.Companion.safeGestures: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().safeGestures

/**
 * The insets that include all areas that may be drawn over or have gesture confusion.
 */
@ExperimentalSoftwareKeyboardApi
actual val WindowInsets.Companion.safeContent: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = WindowInsetsHolder.current().safeDrawing
