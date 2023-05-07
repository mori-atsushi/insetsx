package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable

expect val WindowInsets.Companion.navigationBars: WindowInsets
    @Composable get

expect val WindowInsets.Companion.statusBars: WindowInsets
    @Composable get

expect val WindowInsets.Companion.systemBars: WindowInsets
    @Composable get

/**
 * The insets that include unsafe areas such as system bars and display cutouts,
 * but not including ime.
 *
 * * In Android: system bars + display cutouts (not including IME)
 * * In iOS: safe area (not including IME)
 */
expect val WindowInsets.Companion.safeArea: WindowInsets
    @Composable get

@ExperimentalSoftwareKeyboardApi
expect val WindowInsets.Companion.ime: WindowInsets
    @Composable get

@ExperimentalSoftwareKeyboardApi
expect val WindowInsets.Companion.safeDrawing: WindowInsets
    @Composable get
