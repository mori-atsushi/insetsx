package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

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
 * * In iOS: bottom of safe area (home indicator)
 * * In desktop and web: return 0
 */
expect val WindowInsets.Companion.systemGestures: WindowInsets
    @Composable get

/**
 * The insets representing the tappable element.
 *
 * * In Android: tappable element
 * * In iOS: top of safe area (status bar)
 * * In desktop and web: return 0
 */
expect val WindowInsets.Companion.tappableElement: WindowInsets
    @Composable get

/**
 * The insets representing curved areas in a waterfall display.
 *
 * * In Android: waterfall
 * * In iOS, desktop and web: return 0
 */
expect val WindowInsets.Companion.waterfall: WindowInsets
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
 * The insets representing system gestures that have priority and may consume some or all touch
 * input.
 *
 * * In Android: mandatory system gestures
 * * In iOS: bottom of safe area (home indicator)
 * * In desktop and web: return 0
 */
expect val WindowInsets.Companion.mandatorySystemGestures: WindowInsets
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

/**
 * The insets that include areas where gestures may be confused with other input.
 *
 * * In Android: [system gestures][systemGestures] + [mandatory system gestures][mandatorySystemGestures],
 * [rounded display areas][waterfall], and [tappable areas][tappableElement].
 * * In iOS: top and bottom of safe area (home indicator + status bar)
 * * In desktop and web: return 0
 */
expect val WindowInsets.Companion.safeGestures: WindowInsets
    @Composable get

/**
 * The insets that include all areas that may be drawn over or have gesture confusion.
 *
 * * In Android: [systemGestures] + [safeGestures].
 * * In iOS: safe area + IME
 * * In desktop and web: return 0
 */
expect val WindowInsets.Companion.safeContent: WindowInsets
    @Composable get

/**
 * It always returns 0.
 */
internal val WindowInsets.Companion.zero: WindowInsets
    get() = ZeroWindowInsets

@Immutable
private object ZeroWindowInsets : WindowInsets {
    override fun getBottom(density: Density): Int {
        return 0
    }

    override fun getLeft(density: Density, layoutDirection: LayoutDirection): Int {
        return 0
    }

    override fun getRight(density: Density, layoutDirection: LayoutDirection): Int {
        return 0
    }

    override fun getTop(density: Density): Int {
        return 0
    }
}
