package com.moriatsushi.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout as androidDisplayCutout
import androidx.compose.foundation.layout.ime as androidIme
import androidx.compose.foundation.layout.navigationBars as androidNavigationBars
import androidx.compose.foundation.layout.safeDrawing as androidSafeDrawing
import androidx.compose.foundation.layout.statusBars as androidStatusBars
import androidx.compose.foundation.layout.systemBars as androidSystemBars
import androidx.compose.foundation.layout.union
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable

actual val WindowInsets.Companion.navigationBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidNavigationBars

actual val WindowInsets.Companion.statusBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidStatusBars

actual val WindowInsets.Companion.systemBars: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidSystemBars

/**
 * The insets that include unsafe areas such as system bars and display cutouts.
 */
actual val WindowInsets.Companion.safeArea: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidSystemBars.union(androidDisplayCutout)

actual val WindowInsets.Companion.ime: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidIme

actual val WindowInsets.Companion.safeDrawing: WindowInsets
    @Composable
    @NonRestartableComposable
    get() = androidSafeDrawing
