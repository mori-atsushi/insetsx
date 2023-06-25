package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable

/**
 * The insets representing navigation bars.
 *
 * When the navigation bars are hidden, all values are changed to 0.
 *
 * * In Android: navigation bars
 * * In iOS: bottom of safe area (home indicator)
 * * In desktop and web: return 0
 */
expect val WindowInsets.Companion.navigationBars: WindowInsets
    @Composable get

/**
 * The insets representing status bars.
 *
 * When the status bars are hidden, all values are changed to 0.
 *
 * * In Android: status bars
 * * In iOS: top of safe area (status bar)
 * * In desktop and web: return 0
 */
expect val WindowInsets.Companion.statusBars: WindowInsets
    @Composable get

/**
 * The insets representing system bars ([navigationBars] + [statusBars]),
 * but not including [ime].
 *
 * * In Android: navigation bars + status bars + caption bars
 * * In iOS: top and bottom of safe area (home indicator + status bar)
 * * In desktop and web: return 0
 */
expect val WindowInsets.Companion.systemBars: WindowInsets
    @Composable get

/**
 * The insets representing system gestures that have priority and may consume some or all touch
 * input.
 *
 * * In Android: system gestures
 * * In iOS: top and bottom (home indicator)
 * * In desktop and web: return 0
 */
expect val WindowInsets.Companion.systemGestures: WindowInsets
    @Composable get

/**
 * The insets that include unsafe areas such as system bars and display cutouts,
 * but not including [ime].
 *
 * * In Android: system bars + display cutouts (not including IME)
 * * In iOS: safe area (not including IME)
 * * In desktop and web: return 0
 */
expect val WindowInsets.Companion.safeArea: WindowInsets
    @Composable get

/**
 * The insets representing the area of the software keyboard.
 *
 * * In Android: IME
 * * In iOS: IME
 * * In desktop and web: return 0
 */
@ExperimentalSoftwareKeyboardApi
expect val WindowInsets.Companion.ime: WindowInsets
    @Composable get

/**
 * The insets that include areas where content may be covered by other drawn content.
 *
 * * In Android: system bars + display cutouts + IME
 * * In iOS: safe area + IME
 * * In desktop and web: return 0
 */
@ExperimentalSoftwareKeyboardApi
expect val WindowInsets.Companion.safeDrawing: WindowInsets
    @Composable get
