package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

/**
 * It always returns 0 because desktop has no window insets.
 */
actual val WindowInsets.Companion.navigationBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = EmptyWindowInsets

/**
 * It always returns 0 because desktop has no window insets.
 */
actual val WindowInsets.Companion.statusBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = EmptyWindowInsets

/**
 * It always returns 0 because desktop has no window insets.
 */
actual val WindowInsets.Companion.systemBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = EmptyWindowInsets

/**
 * It always returns 0 because desktop has no window insets.
 */
actual val WindowInsets.Companion.safeArea: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = EmptyWindowInsets

/**
 * It always returns 0 because desktop has no window insets.
 */
actual val WindowInsets.Companion.ime: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = EmptyWindowInsets

/**
 * It always returns 0 because desktop has no window insets.
 */
actual val WindowInsets.Companion.safeDrawing: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = EmptyWindowInsets

@Immutable
private object EmptyWindowInsets : WindowInsets {
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
