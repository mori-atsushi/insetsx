package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout as androidDisplayCutout
import androidx.compose.foundation.layout.ime as androidIme
import androidx.compose.foundation.layout.navigationBars as androidNavigationBars
import androidx.compose.foundation.layout.safeDrawing as androidSafeDrawing
import androidx.compose.foundation.layout.statusBars as androidStatusBars
import androidx.compose.foundation.layout.systemBars as androidSystemBars
import androidx.compose.foundation.layout.systemGestures as androidSystemGestures
import androidx.compose.foundation.layout.union
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable

/**
 * The insets representing navigation bars.
 */
actual val WindowInsets.Companion.navigationBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidNavigationBars

/**
 * The insets representing status bars.
 */
actual val WindowInsets.Companion.statusBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidStatusBars

/**
 * The insets representing system bars, but not including ime.
 */
actual val WindowInsets.Companion.systemBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidSystemBars

/**
 * The insets representing system gestures that have priority and may consume some or all touch
 * input.
 */
actual val WindowInsets.Companion.systemGestures: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidSystemGestures

/**
 * The insets that include unsafe areas such as system bars and display cutouts,
 * but not including ime.
 */
actual val WindowInsets.Companion.safeArea: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidSystemBars.union(androidDisplayCutout)

/**
 * The insets representing the area of the software keyboard.
 */
actual val WindowInsets.Companion.ime: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidIme

/**
 * The insets that include areas where content may be covered by other drawn content.
 */
actual val WindowInsets.Companion.safeDrawing: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidSafeDrawing
